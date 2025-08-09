package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ElarLogisticsAddDriverPage {
    WebDriver driver;

    public ElarLogisticsAddDriverPage(){
        driver = Driver.getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@value='is_staff']")
    public WebElement staffCheckBox;

    @FindBy(xpath = "//label[text()='Other location']/../following-sibling::div/button")
    public WebElement otherLocationSearchBtn;

    // is only clickable after "otherLocationSearchBtn" is clicked
    @FindBy(xpath = "//label[text()='Search...']/following-sibling::div/input")
    public WebElement otherLocationsSearchPopUpTextBox;

    @FindBy(xpath = "//label[text()='Other location']/following-sibling::div/input")
    public WebElement otherLocationsTextBox;

    @FindBy(xpath = "//button[text()='Create New']")
    public WebElement otherLocationsPopUpCreateNewBtn;

    @FindBy(xpath = "//button[text()='Create']")
    public WebElement otherLocationsPopUpCreateBtn;

    @FindBy(xpath = "//label[text()='Other location']/../following-sibling::div/button")
    public WebElement otherLocationsTrashBtn;

    @FindBy(name = "full_name")
    public WebElement fullNameTextBox;

    @FindBy(name = "is_local")
    public WebElement localCheckBox;

    // LocalStateSelect is only clickable after "localCheckBox" is selected
    @FindBy(name = "local_state")
    public WebElement localStateSelect;

    @FindBy(xpath = "//p[text()='Phone']/following-sibling::button[1]")
    public WebElement addPhoneBtn;

    // only available after "addPhoneBtn" is clicked
    @FindBy(xpath = "//input[@type='tel']")
    public WebElement phoneTextBox;

    // only available after "addPhoneBtn" is clicked
    @FindBy(xpath = "//label[text()='Ext.']/following-sibling::div/input")
    public WebElement phoneExtTextBox;

    @FindBy(xpath = "//p[text()='Email']/following-sibling::button[1]")
    public WebElement addEmailBtn;

    // only available after "addEmailBtn" is clicked
    @FindBy(xpath = "//input[@placeholder='Email']")
    public WebElement emailTextBox;

    // accepts 8 digits
    @FindBy(name = "driving_license_exp")
    public WebElement drivingLicenceExpTextBox;

    @FindBy(xpath = "//input[@value='MM/DD/YYYY']/following-sibling::div/button")
    public WebElement drivingLicenceExpCalanderBtn;

//    @FindBy(xpath = "")
//    public WebElement drivingLicenceInputExpiredDate;
//
//    @FindBy(xpath = "/html/body/div[2]/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/button[1]")
//    public WebElement drivingLicenceInputFutureDate;
//
//    @FindBy(xpath = "/html/body/div[2]/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[1]/button[2]")
//    public WebElement drivingLicenceInputTodaysDate;

    // accepts 8 digits
    @FindBy(name = "medical_certification_exp")
    public WebElement medicalLicenceExpTextBox;

    @FindBy(xpath = "//input[@name='medical_certification_exp']/following-sibling::div/button")
    public WebElement medicalLicenseCalanderBtn;

//    @FindBy(xpath = "/html/body/div[2]/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/button[4]")
//    public WebElement medicalLicenceInputExpiredDate;
//
//    @FindBy(xpath = "/html/body/div[2]/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[3]/button[4]")
//    public WebElement medicalLicenceInputFutureDate;
//
//    @FindBy(xpath = "/html/body/div[2]/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[1]/button[2]")
//    public WebElement medicalLicenseInputTodaysDate;

    @FindBy(xpath = "//label[text()='Logbook #']/following-sibling::div/input")
    public WebElement logbookNumberTextBox;

    // only clickable after "logBookNumberTextBox" is filled in
    @FindBy(name = "logbook_email")
    public WebElement logbookEmailTextBox;

    // only clickable after "logbookEmailTextBox" is filled in
    @FindBy(name = "logbook_password")
    public WebElement logbookPasswordTextBox;

    @FindBy(xpath = "//button[text()='Create new']")
    public WebElement createNewBtn;

    @FindBy(xpath = "//p[text()='Required'][2]")
    public WebElement requiredErrorMessage;

    @FindBy(xpath = "//p[text()='String must contain at most 50 character(s)']")
    public WebElement maxCharNameErrorMessage;

    @FindBy(xpath = "//p[text()='Input must contain only alphanumeric and specific punctuation characters']")
    public WebElement alphanumericErrorMessage;

    @FindBy(xpath = "//p[text()='Enter the correct email address']")
    public WebElement correctEmailErrorMessage;

    @FindBy(xpath = "//p[text()='String must contain at most 50 character(s)']")
    public WebElement maxCharEmailErrorMessage;

    @FindBy(xpath = "//h2[text()='Driver Created Successfully']")
    public WebElement driverCreatedSuccessfullyMessage;

}
