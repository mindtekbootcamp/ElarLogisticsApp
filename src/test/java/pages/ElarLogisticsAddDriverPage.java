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

    @FindBy(id = "uniforms-0005-0003")
    public WebElement localCheckBox;

    // LocalStateSelect is only clickable after "localCheckBox" is selected
    @FindBy(id = "uniforms-0005-0004")
    public WebElement localStateSelect;

    @FindBy(xpath = "//*[@id=root]/div[1]/main/div[2]/div/div/div/form/button[1]")
    public WebElement addPhoneBtn;

    // only available after "addPhoneBtn" is clicked
    @FindBy(id = ":rh5:")
    public WebElement phoneTextBox;

    // only available after "addPhoneBtn" is clicked
    @FindBy(id = "uniforms-0005-0005")
    public WebElement phoneExtTextBox;

    @FindBy(xpath = "//*[@id=root]/div[1]/main/div[2]/div/div/div/form/button[2]")
    public WebElement addEmailBtn;

    // only available after "addEmailBtn" is clicked
    @FindBy(id = "uniforms-0005-0006")
    public WebElement emailTextBox;

    // accepts 8 digits
    @FindBy(id = "uniforms-0005-000c")
    public WebElement drivingLicenceExpTextBox;

    @FindBy(xpath = "//*[@id=root]/div[1]/main/div[2]/div/div/div/form/div[9]/div/div/div/button")
    public WebElement drivingLicenceExpCalanderBtn;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[3]/button[3]")
    public WebElement drivingLicenceInputExpiredDate;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/button[1]")
    public WebElement drivingLicenceInputFutureDate;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[1]/button[2]")
    public WebElement drivingLicenceInputTodaysDate;

    // accepts 8 digits
    @FindBy(id = "uniforms-0005-000d")
    public WebElement medicalLicenceExpTextBox;

    @FindBy(xpath = "//*[@id=root]/div[1]/main/div[2]/div/div/div/form/div[10]/div/div/div/button")
    public WebElement medicalLicenseCalanderBtn;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/button[4]")
    public WebElement medicalLicenceInputExpiredDate;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[3]/button[4]")
    public WebElement medicalLicenceInputFutureDate;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[1]/button[2]")
    public WebElement medicalLicenseInputTodaysDate;

    @FindBy(id = "uniforms-0005-000g")
    public WebElement logbookNumberTextBox;

    // only clickable after "logBookNumberTextBox" is filled in
    @FindBy(id = "uniforms-0005-000h")
    public WebElement logbookEmailTextBox;

    // only clickable after "logbookEmailTextBox" is filled in
    @FindBy(id = "uniforms-0005-000i")
    public WebElement logbookPasswordTextBox;

    @FindBy(xpath = "//*[@id=root]/div[1]/main/div[2]/div/div/div/form/div[19]/button")
    public WebElement createNewBtn;

    @FindBy(xpath = "//*[@id=root]/div[1]/main/div[2]/div/div/div/form/div[19]/p[1]")
    public WebElement requiredErrorMessage;

    @FindBy(id = "uniforms-000a-0002-helper-text")
    public WebElement maxCharNameErrorMessage;

    @FindBy(id = "uniforms-000a-0002-helper-text")
    public WebElement alphanumericErrorMessage;

    @FindBy(id = "uniforms-000a-0006-helper-text")
    public WebElement correctEmailErrorMessage;

    @FindBy(id = "uniforms-000a-0006-helper-text")
    public WebElement maxCharEmailErrorMessage;

    @FindBy(id = ":re7:")
    public WebElement driverCreatedSuccessfullyMessage;

}
