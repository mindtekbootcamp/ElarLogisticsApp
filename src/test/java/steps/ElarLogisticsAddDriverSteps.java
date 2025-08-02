package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import utilities.Driver;

public class ElarLogisticsAddDriverSteps {

    WebDriver driver = Driver.getDriver();

    /**
     * Login steps
     */
    @Given("user logs in to to elar logistics app")
    public void user_logs_in_to_to_elar_logistics_app() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("user navigates to the Add Driver page")
    public void user_navigates_to_the_add_driver_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    /**
     * Minimum requirement steps
     */
    @When("user clicks on Create button")
    public void user_clicks_on_create_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("user validates error message is shown {string}")
    public void user_validates_error_message_is_shown(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("user enters valid full name {string}")
    public void user_enters_valid_full_name(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("user selects valid driving license expiration date")
    public void user_selects_valid_driving_license_expiration_date() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("user selects valid medical license expiration date")
    public void user_selects_valid_medical_license_expiration_date() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("user enters valid input into Logbook# field")
    public void user_enters_valid_input_into_logbook_field() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("user enters valid input into Logbookemail field")
    public void user_enters_valid_input_into_logbookemail_field() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("user validates success message is displayed {string}")
    public void user_validates_success_message_is_displayed(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
