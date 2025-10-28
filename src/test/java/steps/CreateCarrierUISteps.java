package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.ElarAddCarrierPage;
import pages.ElarCarriersPage;
import pages.ElarLogisticsMainPage;
import utilities.BrowserUtils;

import utilities.DataTableUtils;
import utilities.Driver;


import java.util.Map;

public class CreateCarrierUISteps {

    WebDriver driver = Driver.getDriver();
    ElarAddCarrierPage elarAddCarrierPage = new ElarAddCarrierPage();

    @When("user navigates to the Carriers page")
    public void user_navigates_to_the_carriers_page() {
        ElarLogisticsMainPage elarLogisticsMainPage = new ElarLogisticsMainPage();
        elarLogisticsMainPage.mainPageCarrierBtn.click();
    }

    @When("user clicks on Add Carrier button")
    public void user_clicks_on_add_carrier_button() throws InterruptedException {
        ElarCarriersPage elarCarriersPage = new ElarCarriersPage();
        //BrowserUtils.waitForElementToBeClickable(elarCarriersPage.getAddCarrierBtnLocator()).click();
        BrowserUtils.waitForElementToBeClickable(elarCarriersPage.addCarrierBtn);
        elarCarriersPage.addCarrierBtn.click();
    }

    @When("user enters required data fields")
    public void user_enters_required_data_fields(DataTable dataTable) throws InterruptedException {
        Map<String, Object> data = dataTable.asMap(String.class, Object.class);
        elarAddCarrierPage.carrierNameInput.sendKeys(DataTableUtils.compareIfNameIsUnique(data, "carrier_name", "$unique Co"));
        elarAddCarrierPage.abbreviationInput.sendKeys(DataTableUtils.compareIfAbbreviationIsUnique(data, "abbreviation", "$unique short"));
        elarAddCarrierPage.companyTypeDropDown.click();
        WebElement brokerCompanySelect = driver.findElement(By.xpath("//li[@data-value='" + data.get("carrier_type") + "']"));
        brokerCompanySelect.click();
        elarAddCarrierPage.mcNumInput.sendKeys(DataTableUtils.compareIfNumberIsUnique(data, "mc_number", "$unique long"));
        elarAddCarrierPage.dotNumInput.sendKeys(DataTableUtils.compareIfNumberIsUnique(data, "dot_number", "$unique long"));
        BrowserUtils.scrollingIntoView(elarAddCarrierPage.policyNumberInput);
        elarAddCarrierPage.insuranceInput.sendKeys(data.get("insurance").toString());
        elarAddCarrierPage.policyExpirationInput.click();
        elarAddCarrierPage.policyExpirationInput.sendKeys(data.get("policy_expiration").toString());
        elarAddCarrierPage.policyNumberInput.sendKeys(data.get("policy_number").toString());
    }

    @When("user clicks the Address Search button")
    public void user_clicks_the_address_search_button() {
        elarAddCarrierPage.addressSearchBtn.click();
    }

    @When("user clicks the first address")
    public void user_clicks_the_first_address() {
        elarAddCarrierPage.addressSelect.click();
    }

    @When("user clicks Create New Button for Carriers")
    public void user_clicks_create_new_button_for_carriers() throws InterruptedException {
        BrowserUtils.scrollingIntoView(elarAddCarrierPage.createNewBtn);
        elarAddCarrierPage.createNewBtn.click();
    }

    @Then("user validates Carrier Created Successfully message {string}")
    public void user_validates_carrier_created_successfully_message(String expectedSuccessMessage) throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals(expectedSuccessMessage, elarAddCarrierPage.carrierSuccessMsg.getText());
    }

    @Then("user validates Carrier error message for name with 0 characters {string}")
    public void user_validates_carrier_error_message_for_name_with_0_characters(String expectedErrorMessage) {
        Assert.assertEquals(expectedErrorMessage, elarAddCarrierPage.shortNameErrorMsg.getText());
    }

    @Then("user validates Carrier error message for name with more than 50 characters {string}")
    public void user_validates_carrier_error_message_for_name_with_more_than_50_characters(String expectedErrorMessage) {
        Assert.assertEquals(expectedErrorMessage, elarAddCarrierPage.longNameErrorMsg.getText());
    }

    @Then("user validates Carrier error message for name with special characters {string}")
    public void user_validates_carrier_error_message_for_name_with_special_characters(String expectedErrorMessage) {
        Assert.assertEquals(expectedErrorMessage, elarAddCarrierPage.specialCharNameErrorMsg.getText());
    }

    @Then("user validates Carrier error message for Abbreviation with 0 characters {string}")
    public void user_validates_carrier_error_message_for_abbreviation_with_0_characters(String expectedErrorMessage) {
        Assert.assertEquals(expectedErrorMessage, elarAddCarrierPage.shortAbbrevErrorMsg.getText());
    }

    @Then("user validates Carrier error message for Abbreviation with more than 3 characters {string}")
    public void user_validates_carrier_error_message_for_abbreviation_with_more_than_3_characters(String expectedErrorMessage) {
        Assert.assertEquals(expectedErrorMessage, elarAddCarrierPage.longAbbrevErrorMsg.getText());
    }

    @Then("user validates Carrier error message for Abbreviation with special characters {string}")
    public void user_validates_carrier_error_message_for_abbreviation_with_special_characters(String expectedErrorMessage) {
        Assert.assertEquals(expectedErrorMessage, elarAddCarrierPage.specialCharAbbrevErrorMsg.getText());
    }
}
