package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;

public class ElarLogisticsLoginPage {

    WebDriver driver;

    public ElarLogisticsLoginPage(){
        driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "login-username")
    public WebElement usernameInput;

    @FindBy(id = "login-password")
    public WebElement passwordInput;

    @FindBy(css = "button[type='submit']")
    public WebElement loginBtn;

    @FindBy(css = "button[class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-1egpgfe']")
    public WebElement hidePWBtn;

    @FindBy(xpath = "//*[@id='root']/div[2]/div/div/div[2]")
    public WebElement invalidMsg;

    public void loginUser(){
        usernameInput.sendKeys(ConfigReader.getProperty("ElarUsername"));
        passwordInput.sendKeys(ConfigReader.getProperty("ElarPassword"));
        loginBtn.click();
    }
}
