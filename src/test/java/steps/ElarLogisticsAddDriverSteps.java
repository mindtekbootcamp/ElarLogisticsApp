package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import pages.ElarLogisticsAddDriverPage;
import pages.ElarLogisticsDriverPage;
import pages.ElarLogisticsLoginPage;
import pages.ElarLogisticsMainPage;
import utilities.BrowserUtils;
import utilities.ConfigReader;
import utilities.Driver;

public class ElarLogisticsAddDriverSteps {

    WebDriver driver = Driver.getDriver();
    ElarLogisticsAddDriverPage elarLogisticsAddDriverPage = new ElarLogisticsAddDriverPage();

    /**
     * Setup
     */
    @Given("user logs in to to elar logistics app")
    public void user_logs_in_to_to_elar_logistics_app() {
        driver.get(ConfigReader.getProperty("elarlogisticsURL"));
        ElarLogisticsLoginPage elarLogisticsLoginPage = new ElarLogisticsLoginPage();
        elarLogisticsLoginPage.usernameInput.sendKeys("ElarUsername");
        elarLogisticsLoginPage.passwordInput.sendKeys("ElarPassword");
        elarLogisticsLoginPage.loginBtn.click();
    }

    @When("user navigates to the Drivers page")
    public void user_navigates_to_the_drivers_page() {
        ElarLogisticsMainPage elarLogisticsMainPage = new ElarLogisticsMainPage();
        elarLogisticsMainPage.mainPageDriversBtn.click();
    }

    @When("user clicks on Add Driver button")
    public void user_clicks_on_add_driver_button() {
        ElarLogisticsDriverPage elarLogisticsDriverPage = new ElarLogisticsDriverPage();
        elarLogisticsDriverPage.addDriverBtn.click();
    }

    @When("user clicks Staff checkbox")
    public void user_clicks_staff_checkbox() {
        elarLogisticsAddDriverPage.staffCheckBox.click();
    }

    @When("user enters full name {string}")
    public void user_enters_full_name(String fullName) {
        elarLogisticsAddDriverPage.fullNameTextBox.sendKeys(fullName);
    }

    @When("user selects driving license expiration date {string}")
    public void user_selects_driving_license_expiration_date(String drivingExpDate) {
        elarLogisticsAddDriverPage.drivingLicenceExpTextBox.sendKeys(drivingExpDate);
    }

    @When("user selects medical license expiration date {string}")
    public void user_selects_medical_license_expiration_date(String medicalExpDate) {
        elarLogisticsAddDriverPage.medicalLicenceExpTextBox.sendKeys(medicalExpDate);
    }

    @When("user enters input into Logbook# field")
    public void user_enters_input_into_logbook_field() {
        elarLogisticsAddDriverPage.logbookNumberTextBox.sendKeys(BrowserUtils.uuidIDGenerator());
    }

    @When("user enters input into Logbook email field {string}")
    public void user_enters_input_into_logbook_email_field(String logbookEmail) {
        elarLogisticsAddDriverPage.logbookEmailTextBox.sendKeys(logbookEmail);
    }

    @When("user enters email address {string}")
    public void user_enters_email_address(String emailAddress) {
        elarLogisticsAddDriverPage.addEmailBtn.click();
        elarLogisticsAddDriverPage.emailTextBox.sendKeys(emailAddress);
    }

    @Then("user validates error message for email with special characters is displayed {string}")
    public void user_validates_error_message_for_email_with_special_characters_is_displayed(String expectedErrorMessage) {
        //String actualErrorMessage = elarLogisticsAddDriverPage.error;
        //Assert.assertEquals(expectedErrorMessage,);
    }

    @When("user enters phone number {string}")
    public void user_enters_phone_number(String phoneNumber) {
        elarLogisticsAddDriverPage.addPhoneBtn.click();
        elarLogisticsAddDriverPage.phoneTextBox.sendKeys(phoneNumber);
    }

    @Then("user validates error message for phone number is displayed {string}")
    public void user_validates_error_message_for_phone_number_is_displayed(String expectedErrorMessage) {
        //String actualErrorMessage = elarLogisticsAddDriverPage.error;
        //Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
    }

    @Then("user validates error message for email with more than 50 characters is displayed {string}")
    public void user_validates_error_message_for_email_with_more_than_50_characters_is_displayed(String expectedErrorMessage) {
        String actualErrorMessage = elarLogisticsAddDriverPage.maxCharEmailErrorMessage.getText();
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
    }

    @When("user clicks the Other Location search button")
    public void user_clicks_the_other_location_search_button() {
        elarLogisticsAddDriverPage.otherLocationSearchBtn.click();
    }

    @When("user clicks the Create New button")
    public void user_clicks_the_create_new_button() {
        elarLogisticsAddDriverPage.otherLocationsPopUpCreateNewBtn.click();
    }

    @When("user clicks the Create button")
    public void user_clicks_the_create_button() {
        elarLogisticsAddDriverPage.otherLocationsPopUpCreateBtn.click();
    }

    @Then("user validates created location is selected")
    public void user_validates_created_location_is_selected() {
        //Assert.assertTrue();
    }

    @When("user clicks the trash can button")
    public void user_clicks_the_trash_can_button() {
        elarLogisticsAddDriverPage.otherLocationsTrashBtn.click();
    }

    @Then("user validates created location is deleted")
    public void user_validates_created_location_is_deleted() {
        
    }

    @Then("user validates Staff checkmark is checked")
    public void user_validates_staff_checkmark_is_checked() {
        
    }

    @Then("user validates Staff checkbox is unchecked")
    public void user_validates_staff_checkbox_is_unchecked() {
        
    }

    @When("user clicks on Local checkbox")
    public void user_clicks_on_local_checkbox() {
        elarLogisticsAddDriverPage.staffCheckBox.click();
    }

    @Then("user validates Local checkmark is shown")
    public void user_validates_local_checkmark_is_shown() {
        
    }

    @When("user clicks on Local State dropdown")
    public void user_clicks_on_local_state_dropdown() {
        Select dropdownSelect = new Select(elarLogisticsAddDriverPage.localStateSelect);

    }

    @When("user selects the local state {string}")
    public void user_selects_the_local_state(String string) {
        
    }

    @When("user clicks on Create button")
    public void user_clicks_on_create_button() {
        elarLogisticsAddDriverPage.createNewBtn.click();
    }

    @Then("user validates {string} is shown in the Local State field")
    public void user_validates_is_shown_in_the_local_state_field(String string) {
        
    }

    @Then("user validates Local checkbox is unchecked")
    public void user_validates_local_checkbox_is_unchecked() {
        
    }

    @Then("Local State field is empty")
    public void local_state_field_is_empty() {
        
    }

    @Then("user validates error message for medical license current date is displayed {string}")
    public void user_validates_error_message_for_medical_license_current_date_is_displayed(String string) {
        
    }

    @Then("user validates error message for driving license past date is displayed {string}")
    public void user_validates_error_message_for_driving_license_past_date_is_displayed(String string) {
        
    }

    @Then("user validates error message for name with special characters is displayed {string}")
    public void user_validates_error_message_for_name_with_special_characters_is_displayed(String string) {
        
    }

    @Then("user validates error message for driving license current date is displayed {string}")
    public void user_validates_error_message_for_driving_license_current_date_is_displayed(String string) {
        
    }
    @Then("user validates error message for medical license past date is displayed {string}")
    public void user_validates_error_message_for_medical_license_past_date_is_displayed(String string) {
        
    }
    @Then("user validates error message above Create button is shown {string}")
    public void user_validates_error_message_above_create_button_is_shown(String expectedErrorMessage) {
        String actualErrorMessage = elarLogisticsAddDriverPage.requiredErrorMessage.getText();
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
    }

    @Then("user validates success message is displayed {string}")
    public void user_validates_success_message_is_displayed(String expectedSuccessMessage) {
        String actualSuccessMessage = elarLogisticsAddDriverPage.driverCreatedSuccessfullyMessage.getText();
        Assert.assertEquals(expectedSuccessMessage, actualSuccessMessage);
    }

    @Then("user validates error message for name with more than 50 characters is displayed {string}")
    public void user_validates_error_message_for_name_with_more_than_50_characters_is_displayed(String expectedErrorMessage) {
        String actualErrorMessage = elarLogisticsAddDriverPage.maxCharNameErrorMessage.getText();
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
    }
}
