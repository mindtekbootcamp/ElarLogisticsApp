package steps;


import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import org.openqa.selenium.WebElement;
import pages.ElarLogisticsDriverPage;
import pojos.CreateDriverRequest;
import pojos.CreateDriverResponse;
import utilities.APIUtils;
import utilities.DataLoader;
import utilities.DataTableUtils;


import java.util.List;
import java.util.Map;

public class ElarLogisticsDriverSearchSteps {

    ElarLogisticsDriverPage elarLogisticsDriverPage = new ElarLogisticsDriverPage();
    CreateDriverRequest createDriverRequest = DataLoader.createDriverRequest;

    List<Map<String, Object>> testDrivers;
    String searchedID;
    List<String> idList;
    String searchedFullName;
    String searchedEmail;
    String searchedPhone;

    @When("user clicks on Search field")
    public void user_clicks_on_search_field() {
        elarLogisticsDriverPage.sideBarToggle.click();
        elarLogisticsDriverPage.searchAllBtn.click();
        elarLogisticsDriverPage.driverPageSearch.click();
    }

    @When("user clicks ID button")
    public void user_clicks_id_button() {
        elarLogisticsDriverPage.idSearchBtn.click();
    }

    @When("user enters ID from get call response")
    public void user_enters_id_from_get_call_response() throws InterruptedException {
        CreateDriverResponse createDriverResponse = DataLoader.responseData.get("postResponse").as(CreateDriverResponse.class); // DESERIALIZATION
        searchedID = createDriverResponse.getId().toString();
        elarLogisticsDriverPage.driverPageSearch.sendKeys(searchedID + Keys.ENTER);
        Thread.sleep(500);
    }

    @When("user enters ID {string}")
    public void user_enters_id(String ID) throws InterruptedException {
        searchedID = ID;
        elarLogisticsDriverPage.driverPageSearch.sendKeys(ID + Keys.ENTER);
        Thread.sleep(500);
    }

    @Then("user validates only drivers with provided ID search criteria should be shown")
    public void user_validates_only_drivers_with_provided_id_search_criteria_should_be_shown() {
        List<WebElement> searchResultIds = elarLogisticsDriverPage.searchResultIds;
        Assert.assertFalse(searchResultIds.isEmpty());
        for (WebElement element : searchResultIds) {
            Assert.assertTrue("Assertion error for: " + element.getText() + " id.\nExpected id: " + searchedID, element.getText().contains(searchedID));
        }
    }

    @Then("user validates that no drivers should be shown")
    public void user_validates_that_no_drivers_should_be_shown() {
        List<WebElement> searchResultNoInput = elarLogisticsDriverPage.searchResultIds;
        Assert.assertTrue(searchResultNoInput.isEmpty());
    }

    @Then("user validates that all drivers should be shown")
    public void user_validates_that_all_drivers_should_be_shown() {
        List<WebElement> searchResultNoInput = elarLogisticsDriverPage.searchResultIds;
        Assert.assertFalse(searchResultNoInput.isEmpty());
    }

    @When("user clicks NAME button")
    public void user_clicks_name_button() {
        elarLogisticsDriverPage.nameSearchBtn.click();
    }

    @When("user searches full name from get call response")
    public void user_searches_full_name_from_get_call_response() throws InterruptedException {
        CreateDriverResponse createDriverResponse = DataLoader.responseData.get("postResponse").as(CreateDriverResponse.class); // DESERIALIZATION
        searchedFullName = createDriverResponse.getFull_name();
        elarLogisticsDriverPage.driverPageSearch.sendKeys(searchedFullName + Keys.ENTER);
        Thread.sleep(500);
    }

    @When("user searches full name {string}")
    public void user_searches_full_name(String fullName) throws InterruptedException {
        searchedFullName = fullName;
        elarLogisticsDriverPage.driverPageSearch.sendKeys(fullName + Keys.ENTER);
        Thread.sleep(500);
    }

    @Then("user validates only drivers with provided Full Name search criteria should be shown")
    public void user_validates_only_drivers_with_provided_full_name_search_criteria_should_be_shown() {
        List<WebElement> searchResultNames = elarLogisticsDriverPage.searchResultNames;
        Assert.assertFalse(searchResultNames.isEmpty());
        for (WebElement element : searchResultNames) {
            Assert.assertTrue(element.getText().contains(searchedFullName));
        }
    }

    @When("user clicks EMAIL or PHONE button")
    public void user_clicks_email_phone_button() {
        elarLogisticsDriverPage.emailPhoneSearchBtn.click();

    }

    @When("user searches email address from get call response")
    public void user_searches_email_address_from_get_call_response() throws InterruptedException {
        CreateDriverResponse createDriverResponse = DataLoader.responseData.get("postResponse").as(CreateDriverResponse.class); // DESERIALIZATION
        searchedEmail = createDriverResponse.getContacts_email().toString();
        elarLogisticsDriverPage.driverPageSearch.sendKeys(searchedEmail + Keys.ENTER);
        Thread.sleep(500);
    }

    @When("user searches email address {string}")
    public void user_searches_email_address(String email) throws InterruptedException {
        searchedEmail = email;
        elarLogisticsDriverPage.driverPageSearch.sendKeys(email + Keys.ENTER);
        Thread.sleep(500);
    }

    @Then("user validates only drivers with provided Email search criteria should be shown")
    public void user_validates_only_drivers_with_provided_email_search_criteria_should_be_shown() {
        List<WebElement> searchResultEmails = elarLogisticsDriverPage.searchResultEmails;
        Assert.assertFalse(searchResultEmails.isEmpty());
        for (WebElement element : searchResultEmails) {
            Assert.assertTrue(element.getText().contains(searchedEmail));
        }
    }

    @When("user searches phone number from get call response")
    public void user_searches_phone_number_from_get_call_response() throws InterruptedException {
        CreateDriverResponse createDriverResponse = DataLoader.responseData.get("postResponse").as(CreateDriverResponse.class); // DESERIALIZATION
        searchedPhone = createDriverResponse.getContacts_phone().toString();
        elarLogisticsDriverPage.driverPageSearch.sendKeys(searchedPhone + Keys.ENTER);
        Thread.sleep(500);
    }

    @When("user searches phone number {string}")
    public void user_searches_phone_number(String phoneNumber) {
        searchedPhone = phoneNumber;
        elarLogisticsDriverPage.driverPageSearch.sendKeys(phoneNumber + Keys.ENTER);

    }

    @Then("user validates only drivers with provided Phone search criteria should be shown")
    public void user_validates_only_drivers_with_provided_phone_search_criteria_should_be_shown() {
        searchedPhone = searchedPhone.replaceAll("\\D", "");
        List<WebElement> searchResultPhones = elarLogisticsDriverPage.searchResultPhones;
        Assert.assertFalse(searchResultPhones.isEmpty());
        for (WebElement element : searchResultPhones) {
            String digitOnlyResult = element.getText().replaceAll("\\D", "");
            Assert.assertTrue(digitOnlyResult.contains(searchedPhone));
        }
    }
}
