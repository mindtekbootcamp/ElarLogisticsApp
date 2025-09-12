package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EditDriverAPISteps {

    @Given("User sends put API call with data")
    public void User_sends_put_api_call_with_data() {

    }

    @Then("User validates status code {int}")
    public void User_validates_status_code(Integer statusCode) {

    }

    @When("User gets updated driver with get call")
    public void User_gets_updated_driver_with_get_call() {

    }

    @Then("User validates updated driver data in get call response")
    public void User_validates_updated_driver_data_in_get_call_response() {

    }

    @Given("User sends put API call with data")
    public void User_sends_put_api_call_with_data(DataTable dataTable) {

    }

    @Then("User validates Edit Driver full_name response status code {int}")
    public void User_validates_edit_driver_full_name_response_status_code(Integer statusCode) {

    }

    @Then("User validates Edit Driver full_name response body error message {string}")
    public void User_validates_edit_driver_full_name_response_body_error_message(String errorMessage) {

    }

    @Then("User validates Edit Driver is_staff status code {int}")
    public void User_validates_edit_driver_is_staff_status_code(Integer statusCode) {

    }

    @And("User validates updated_at field having the correct date")
    public void userValidatesUpdated_atFieldHavingTheCorrectDate() {
    }
}
