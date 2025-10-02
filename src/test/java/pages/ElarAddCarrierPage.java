package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ElarAddCarrierPage {

    WebDriver driver;
    public ElarAddCarrierPage(){
        driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()='Name']/../../preceding-sibling::input")
    public WebElement carrierNameInput;

    @FindBy(xpath = "//span[text()='Abbreviation']/../../preceding-sibling::input")
    public WebElement abbreviationInput;

    @FindBy(xpath = "//input[@name='carrier_type']/preceding-sibling::div")
    public WebElement companyTypeDropDown;

    @FindBy(xpath = "//span[text()='MC #']/../../../input")
    public WebElement mcNumInput;

    @FindBy(xpath = "//span[text()='DOT #']/../../../input")
    public WebElement dotNumInput;

    @FindBy(xpath = "//label[text()='Address']/../following-sibling::*/button")
    public WebElement addressSearchBtn;

    @FindBy(xpath = "(//div[@data-field='address' and @role='cell'])[1]")
    public WebElement addressSelect;

    @FindBy(xpath = "//input[@name='insurance']")
    public WebElement insuranceInput;

    @FindBy(xpath = "//input[@name='policy_expiration']")
    public WebElement policyExpirationInput;

    @FindBy(xpath = "//input[@name='policy_number']")
    public WebElement policyNumberInput;

    @FindBy(xpath = "//button[text()='Create new']")
    public WebElement createNewBtn;

    @FindBy(xpath = "//h2[text()='Carrier Created Successfully']")
    public WebElement carrierSuccessMsg;

    @FindBy(xpath = "//span[text()='Name']/../../../following-sibling::p")
    public WebElement shortNameErrorMsg;

    @FindBy(xpath = "//span[text()='Name']/../../../following-sibling::p")
    public WebElement longNameErrorMsg;

    @FindBy(xpath = "//span[text()='Name']/../../../following-sibling::p")
    public WebElement specialCharNameErrorMsg;

    @FindBy(xpath = "//span[text()='Abbreviation']/../../../following-sibling::p")
    public WebElement shortAbbrevErrorMsg;

    @FindBy(xpath = "//span[text()='Abbreviation']/../../../following-sibling::p")
    public WebElement longAbbrevErrorMsg;

    @FindBy(xpath = "//span[text()='Abbreviation']/../../../following-sibling::p")
    public WebElement specialCharAbbrevErrorMsg;
}
