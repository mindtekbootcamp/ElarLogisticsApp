package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.ElarLogisticsDriverPage;
import utilities.Driver;

import java.util.List;

public class ElarLogisticsDriverSearchSteps {

    WebDriver driver = Driver.getDriver();
    ElarLogisticsDriverPage elarLogisticsDriverPage=new ElarLogisticsDriverPage();

    String searchedID;

    @When("user clicks on Search field")
    public void user_clicks_on_search_field() {
        elarLogisticsDriverPage.driverPageSearch.click();
    }
    @When("user clicks ID button")
    public void user_clicks_id_button() {
        elarLogisticsDriverPage.idSearchBtn.click();
    }
    @When("user enters ID {string}")
    public void user_enters_id(String ID) throws InterruptedException {
        searchedID=ID;
        elarLogisticsDriverPage.driverPageSearch.sendKeys(ID + Keys.ENTER);
        Thread.sleep(5000);
    }
    @Then("user validates only drivers with provided ID search criteria should be shown")
    public void user_validates_only_drivers_with_provided_id_search_criteria_should_be_shown() {
        List<WebElement> searchResultIds=elarLogisticsDriverPage.searchResultIds;
        for(WebElement element: searchResultIds){
            Assert.assertEquals(searchedID, element.getText());
        }
    }

    @Then("user validates that no drivers should be shown")
    public void user_validates_that_no_drivers_should_be_shown() {

    }
    @Then("user validates that all drivers should be shown")
    public void user_validates_that_all_drivers_should_be_shown() {

    }
    @When("user clicks NAME button")
    public void user_clicks_name_button() {

    }
    @When("user searches full name {string}")
    public void user_searches_full_name(String string) {

    }
    @Then("user validates only drivers with provided Full Name search criteria should be shown")
    public void user_validates_only_drivers_with_provided_full_name_search_criteria_should_be_shown() {

    }
    @When("user clicks EMAIL\\/PHONE button")
    public void user_clicks_email_phone_button() {

    }
    @When("user searches email address {string}")
    public void user_searches_email_address(String string) {

    }
    @Then("user validates only drivers with provided Email search criteria should be shown")
    public void user_validates_only_drivers_with_provided_email_search_criteria_should_be_shown() {

    }

    @When("user searches phone number {string}")
    public void user_searches_phone_number(String string) {
        
    }
    @Then("user validates only drivers with provided Phone search criteria should be shown")
    public void user_validates_only_drivers_with_provided_phone_search_criteria_should_be_shown() {
        
    }

    @And("user clicks EMAIL or PHONE button")
    public void userClicksEMAILOrPHONEButton() {
    }
}
