package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    private static WebDriver driver;

    public static WebDriver getDriver(){
        String browserType = ConfigReader.getProperty("browserType");
        if ( driver == null || ((RemoteWebDriver)driver).getSessionId() == null ){
            switch(browserType){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--disable-notifications", "--guest");
                    options.setHeadless(false);
                    driver = new ChromeDriver(options);
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                default:
                    return driver;
            }
        }
        driver.manage().window().maximize();
        //driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }
}
