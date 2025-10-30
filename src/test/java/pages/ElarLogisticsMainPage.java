package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ElarLogisticsMainPage {

    WebDriver driver;

    public ElarLogisticsMainPage(){
        driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h2[text()='Access denied!']")
    public WebElement welcomeMsg;

    @FindBy(xpath = "//p[text()='Drivers']")
    public WebElement mainPageDriversBtn;

    @FindBy(css = "a[href='/carriers/list']")
    public WebElement mainPageCarrierBtn;
}
