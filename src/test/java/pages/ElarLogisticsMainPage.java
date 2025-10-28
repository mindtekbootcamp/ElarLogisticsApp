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

    @FindBy(css = "h2[class='MuiTypography-root MuiTypography-h2 css-12czkc3']")
    public WebElement welcomeMsg;

    @FindBy(xpath = "//p[text()='Drivers']")
    public WebElement mainPageDriversBtn;

    @FindBy(css = "a[href='/carriers/list']")
    public WebElement mainPageCarrierBtn;
}
