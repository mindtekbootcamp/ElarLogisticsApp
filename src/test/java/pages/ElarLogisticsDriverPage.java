package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class ElarLogisticsDriverPage {
    WebDriver driver;

    public ElarLogisticsDriverPage(){
        driver = Driver.getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//button[text()='Add driver']")
   public WebElement addDriverBtn;

    @FindBy(xpath = "//label[text()='Search...']/following-sibling::div/input")
    public WebElement driverPageSearch;

    @FindBy(xpath = "//div[@id='toggle-sidebar']/button[@type='button']")
    public WebElement sideBarToggle;

    @FindBy(xpath = "//button[text()='ID']")
    public WebElement idSearchBtn;

    @FindBy(xpath = "//button[text()='Name']")
    public WebElement nameSearchBtn;

    @FindBy(xpath = "//button[text()='Email/Phone']")
    public WebElement emailPhoneSearchBtn;

    @FindBy(xpath = "(//div[@role='rowgroup'])[2]//div[@data-field='id']/div")
    public List<WebElement> searchResultIds;

    @FindBy(xpath = "(//div[@role='rowgroup'])[2]//div[@data-field='full_name']/div")
    public List<WebElement> searchResultNames;

    @FindBy(xpath = "(//div[@role='rowgroup'])[2]//div[@data-field='email']/div")
    public List<WebElement> searchResultEmails;

    @FindBy(xpath = "(//div[@role='rowgroup'])[2]//div[@data-field='phone']/div")
    public List<WebElement> searchResultPhones;

    public void searchResults(){

    }
}
