package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;
import pojos.*;

import utilities.APIUtils;
import utilities.DataLoader;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class EditDriverAPISteps {

    EditDriverRequest editDriverRequest = DataLoader.editDriverRequest;
    Response putResponse;
    Response getResponse;
    int driverID = Integer.parseInt(DataLoader.dataLoader.get("driverId").toString());

    @Given("user sends put API call with data")
    public void user_sends_put_api_call_with_data() {
        editDriverRequest.setDefaultValues();
        editDriverRequest.setId(driverID);
        APIUtils.putCall(editDriverRequest, "/drivers/" + driverID);
    }

    @Given("user sends put API call with data with no full_name")
    public void user_sends_put_api_call_with_data_with_no_full_name() {
        editDriverRequest.setDefaultValues();
        editDriverRequest.setFull_name("");
        editDriverRequest.setId(driverID);
        APIUtils.putCall(editDriverRequest, "/drivers/" + driverID);
    }

    @Given("user sends put API call with data with {string} full_name")
    public void user_sends_put_api_call_with_data_with_full_name(String full_name) {
        editDriverRequest.setDefaultValues();
        editDriverRequest.setFull_name(full_name);
        editDriverRequest.setId(driverID);
        APIUtils.putCall(editDriverRequest, "/drivers/" + driverID);
    }

    @Given("user sends put API call with data with is_staff status is {string}")
    public void user_sends_put_api_call_with_data_with_is_staff_status_is(String is_staff) {
        boolean isStaff = Boolean.parseBoolean(is_staff);
        editDriverRequest.setDefaultValues();
        editDriverRequest.setIs_staff(isStaff);
        editDriverRequest.setId(driverID);
        APIUtils.putCall(editDriverRequest, "/drivers/" + driverID);
    }

    @Then("user validates put API status code {int}")
    public void user_validates_put_api_status_code(Integer statusCode) {
        DataLoader.responseData.get("putResponse").then().statusCode(statusCode);
    }

    @When("user gets updated driver with get call")
    public void user_gets_updated_driver_with_get_call() {
        EditDriverResponse editDriverResponse = DataLoader.responseData.get("putResponse").as(EditDriverResponse.class); // DESERIALIZATION
        driverID = editDriverResponse.getId();
        APIUtils.getCall("/drivers/" + driverID);
    }

    @Then("user validates updated driver data in get call response")
    public void user_validates_updated_driver_data_in_get_call_response() {
        Assert.assertEquals(editDriverRequest.getDriver_number(), DataLoader.responseData.get("getResponse").body().jsonPath().get("driver_number"));
        Assert.assertEquals(editDriverRequest.getFull_name(), DataLoader.responseData.get("getResponse").body().jsonPath().get("full_name"));
    }

    @Then("user validates updated_at field having the correct date")
    public void user_validates_updated_at_field_having_the_correct_date() {
        LocalDateTime localDateTime = Instant.now().atZone(ZoneOffset.UTC).toLocalDateTime();
        String currentDate = localDateTime.toString();
        Assert.assertEquals(currentDate, DataLoader.responseData.get("getResponse").body().jsonPath().get("updated_at").toString());
    }

    @Then("user validates Edit Driver full_name response status code {int}")
    public void user_validates_edit_driver_full_name_response_status_code(Integer statusCode) {
        DataLoader.responseData.get("putResponse").then().statusCode(statusCode);
    }

    @Then("user validates Edit Driver full_name response body error message {string}")
    public void user_validates_edit_driver_full_name_response_body_error_message(String errorMessage) {
        String actualErrorMessage = DataLoader.responseData.get("putResponse").body().jsonPath().getString("detail[0].msg");
        Assert.assertEquals(errorMessage, actualErrorMessage);
    }

    @Then("user validates Edit Driver is_staff status code {int}")
    public void user_validates_edit_driver_is_staff_status_code(Integer statusCode) {
        DataLoader.responseData.get("putResponse").then().statusCode(statusCode);
    }

    @Then("user validates updated driver data is_staff is {string} in get call response")
    public void user_validates_updated_driver_data_is_staff_is_in_get_call_response(String is_staff) {
        boolean isStaff = Boolean.parseBoolean(is_staff);
        Assert.assertEquals(isStaff, DataLoader.responseData.get("getResponse").body().jsonPath().get("is_staff"));
    }
}