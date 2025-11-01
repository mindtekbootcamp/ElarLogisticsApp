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
import pojos.ListOfCarriers;
import utilities.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

import static io.restassured.RestAssured.given;

public class Hooks {

    private WebDriver driver;

    @Before
    public void setup(Scenario scenario) throws InterruptedException {
        if (!scenario.getSourceTagNames().contains("@api")) {
            driver = Driver.getDriver();
            System.out.println("Before Scenario Method");
        }
        if (DataLoader.token == null && scenario.getSourceTagNames().contains("@api")) {
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
        }
    }

    @After
    public void teardown(Scenario scenario) {
        if (!scenario.getSourceTagNames().contains("@api")) {
            driver.quit();
            System.out.println("After Scenario Method");
        }
        if (scenario.getSourceTagNames().contains("@api")) {
            System.out.println("After method is running");
            Map<String, Object> queryParamsForDrivers = new HashMap<>();
            queryParamsForDrivers.put("is_staff", Constants.ISSTAFF_TRUE);
            deleteData(queryParamsForDrivers, "/drivers");
            deleteData(new HashMap<>(), "/carriers");
            deleteData(new HashMap<>(), "/addresses");
        }
    }

    public static void deleteData(Map<String, Object> queryParams, String endpoint) {
        List<Integer> listIds;
        do {
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
