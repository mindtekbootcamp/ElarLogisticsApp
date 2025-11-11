package steps;

import io.cucumber.java.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.response.Response;
import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.proxy.CaptureType;
import org.openqa.selenium.By;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pojos.CreateAddressRequest;
import pojos.CreateCarrierRequest;
import pojos.CreateDriverRequest;
import utilities.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

import static io.restassured.RestAssured.given;

public class Hooks {

    private WebDriver driver;

    @Before
    public void setup(Scenario scenario) {
        if (scenario.getSourceTagNames().contains("@ui")) {
            driver = Driver.getDriver();
            System.out.println("Before Scenario Method");
        }
    }

    @After
    public void teardown(Scenario scenario) {
        if (scenario.getSourceTagNames().contains("@ui")) {
            driver.quit();
            System.out.println("After Scenario Method");
        }
    }

    @BeforeAll
    public static void setUp() throws InterruptedException, IOException {
        BrowserMobProxy proxy = new BrowserMobProxyServer();
        proxy.setTrustAllServers(true);
        proxy.start(0);

        // 2) Wire Chrome to ALWAYS use the proxy (avoid bypass)
        Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxy);
        ChromeOptions options = getChromeOptions(seleniumProxy);
        // 3) Enable explicit HAR capture types (headers + bodies if you want)
        proxy.newHar("session-har");
        proxy.enableHarCaptureTypes(
                CaptureType.REQUEST_HEADERS,
                CaptureType.RESPONSE_HEADERS,
                CaptureType.REQUEST_CONTENT,
                CaptureType.RESPONSE_CONTENT
        );

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(options);

        // Start capturing traffic
        driver.get(ConfigReader.getProperty("elarlogisticsURL"));
        Thread.sleep(1000);
        driver.findElement(By.id("login-username")).sendKeys(ConfigReader.getProperty("ElarUsername"));
        driver.findElement(By.id("login-password")).sendKeys(ConfigReader.getProperty("ElarPassword"));
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        Thread.sleep(3000);

        AtomicReference<String> token = new AtomicReference<>("");
        // Get all network entries
        proxy.getHar().getLog().getEntries().forEach(entry -> {
            if (entry.getRequest().getHeaders() != null && !entry.getRequest().getHeaders().isEmpty()) {
                entry.getRequest().getHeaders().forEach(header -> {
                    if (header.getName().equals("Cookie")) {
                        token.set(header.getValue());
                    }
                });
            }
        });
        driver.quit();
        proxy.stop();
        DataLoader.token = token.toString();

        System.out.println("Setting up data...");
        createDriversData("/drivers");
        createAddressesData();
        createCarriersData();
    }

    @AfterAll
    public static void cleanUp(){
        System.out.println("Cleaning up data...");
        deleteData("/drivers");
        deleteData("/carriers");
        deleteData("/addresses");
    }

    public static void createDriversData(String endpoint) throws IOException {
        CreateDriverRequest createDriverRequest = DataLoader.createDriverRequest;
        List<Map<String,Object>> testDrivers=CsvUtils.readCsvAsListOfMaps("TestDataPostCall");
        for (Map<String, Object> elements : testDrivers) {
            createDriverRequest.setDefaultValues();
            createDriverRequest.setFull_name(DataTableUtils.getTableValue(elements, "full_name"));
            createDriverRequest.setIs_staff(Boolean.valueOf(DataTableUtils.getTableValue(elements, "is_staff")));
            createDriverRequest.setDriving_license_exp(DataTableUtils.getTableValue(elements, "driving_license_exp"));
            createDriverRequest.setMedical_certification_exp(DataTableUtils.getTableValue(elements, "medical_certification_exp"));
            createDriverRequest.setContacts_phone(DataTableUtils.getTableValueAsContactsList(elements, "contacts_phone"));
            createDriverRequest.setContacts_email(DataTableUtils.getTableValueAsContactsList(elements, "contacts_email"));
            APIUtils.postCall(createDriverRequest, endpoint);
        }
    }

    private static void createAddressesData() {
        CreateAddressRequest createAddressRequest = DataLoader.createAddressRequest;
        createAddressRequest.setDefaultValues();
        APIUtils.postCall(createAddressRequest, "/addresses");
    }

    private static void createCarriersData() {
        CreateCarrierRequest createCarrierRequest = DataLoader.createCarrierRequest;
        createCarrierRequest.setDefaultValues();
        createCarrierRequest.setAddress_id(DataLoader.responseData.get("postResponse").body().jsonPath().getInt("id"));
        APIUtils.postCall(createCarrierRequest, "/carriers");
    }

    public static void deleteData(String endpoint) {
        List<Integer> listIds;
        do {
            Map<String, Object> queryParams = new HashMap<>();
            queryParams.put("order_by", "id");
            queryParams.put("size", "100");
            APIUtils.getCall(queryParams, endpoint);
            listIds = DataLoader.responseData.get("getResponse").body().jsonPath().getList("items.id");
            System.out.println("Carrier IDs: " + listIds);
            for (Integer id : listIds) {
                Response deleteResponse = given().baseUri(ConfigReader.getProperty("ElarAPIBaseURL"))
                        .and().log().all()
                        .and().header("Cookie", DataLoader.token)
                        .when().delete(endpoint + "/" + id);
                deleteResponse.then().log().all();
            }
        } while (listIds.size() == 100);
    }

    private static ChromeOptions getChromeOptions(Proxy seleniumProxy) {
        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);
        options.setProxy(seleniumProxy);
        options.setHeadless(true);
        // Prevent proxy bypasses
        options.addArguments(
                "--disable-features=NetworkService,NetworkServiceInProcess", // helps older Chrome/BMP combos
                "--proxy-bypass-list=<-loopback>", // don't bypass anything except loopback
                "--disable-quic"                   // QUIC can bypass HTTP proxy path
        );
        return options;
    }
}
