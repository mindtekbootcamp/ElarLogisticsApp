package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;
import pojos.*;

import utilities.ConfigReader;
import utilities.DataLoader;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;

import static io.restassured.RestAssured.given;


public class EditDriverAPISteps {

    EditDriverRequest editDriverRequest = new EditDriverRequest();
    Response putResponse;
    Response getResponse;
    int driverID = Integer.parseInt(DataLoader.dataLoader.get("driverId").toString());

    String token = ConfigReader.getProperty("ElarAPIToken");

    @Given("user sends put API call with data")
    public void user_sends_put_api_call_with_data() {
        editDriverRequest.setDefaultValues();

        editDriverRequest.setId(driverID);

        putResponse = given().baseUri(ConfigReader.getProperty("ElarAPIBaseURL"))
                .and().header("Accept", "application/json")
                .and().header("Content-Type", "application/json")
                .and().header("Cookie", token)
                .and().body(editDriverRequest)
                .and().log().all()
                .when().put("/drivers/" + driverID);
        putResponse.then().log().all();
    }

    @Given("user sends put API call with data with no full_name")
    public void user_sends_put_api_call_with_data_with_no_full_name() {
        editDriverRequest.setDefaultValues();
        editDriverRequest.setFull_name("");
        editDriverRequest.setId(driverID);

        putResponse = given().baseUri(ConfigReader.getProperty("ElarAPIBaseURL"))
                .and().header("Accept", "application/json")
                .and().header("Content-Type", "application/json")
                .and().header("Cookie", token)
                .and().body(editDriverRequest)
                .and().log().all()
                .when().put("/drivers/" + driverID);
        putResponse.then().log().all();
    }

    @Given("user sends put API call with data with {string} full_name")
    public void user_sends_put_api_call_with_data_with_full_name(String full_name) {
        editDriverRequest.setDefaultValues();
        editDriverRequest.setFull_name(full_name);
        editDriverRequest.setId(driverID);

        putResponse = given().baseUri(ConfigReader.getProperty("ElarAPIBaseURL"))
                .and().header("Accept", "application/json")
                .and().header("Content-Type", "application/json")
                .and().header("Cookie", token)
                .and().body(editDriverRequest)
                .and().log().all()
                .when().put("/drivers/" + driverID);
        putResponse.then().log().all();
    }

    @Given("user sends put API call with data with is_staff status is {string}")
    public void user_sends_put_api_call_with_data_with_is_staff_status_is(String is_staff) {
        boolean isStaff = Boolean.parseBoolean(is_staff);
        editDriverRequest.setDefaultValues();
        editDriverRequest.setIs_staff(isStaff);
        editDriverRequest.setId(driverID);

        putResponse = given().baseUri(ConfigReader.getProperty("ElarAPIBaseURL"))
                .and().header("Accept", "application/json")
                .and().header("Content-Type", "application/json")
                .and().header("Cookie", token)
                .and().body(editDriverRequest)
                .and().log().all()
                .when().put("/drivers/" + driverID);
        putResponse.then().log().all();
    }

    @Then("user validates put API status code {int}")
    public void user_validates_put_api_status_code(Integer statusCode) {
        putResponse.then().statusCode(statusCode);
    }

    @When("user gets updated driver with get call")
    public void user_gets_updated_driver_with_get_call() {
        EditDriverResponse editDriverResponse = putResponse.as(EditDriverResponse.class); // DESERIALIZATION
        driverID = editDriverResponse.getId();
        getResponse = given().baseUri(ConfigReader.getProperty("ElarAPIBaseURL"))
                .and().header("Accept", "application/json")
                .and().header("Cookie", token)
                .and().log().all()
                .when().get("/drivers/" + driverID);
        getResponse.then().log().all();
    }

    @Then("user validates updated driver data in get call response")
    public void user_validates_updated_driver_data_in_get_call_response() {
        Assert.assertEquals(editDriverRequest.getDriver_number(), getResponse.body().jsonPath().get("driver_number"));
        Assert.assertEquals(editDriverRequest.getFull_name(), getResponse.body().jsonPath().get("full_name"));
    }

    @Then("user validates updated_at field having the correct date")
    public void user_validates_updated_at_field_having_the_correct_date() {
        LocalDate localDate = Instant.now().atZone(ZoneOffset.UTC).toLocalDate();
        String currentDate = localDate.toString();
        Assert.assertEquals(currentDate, getResponse.body().jsonPath().get("updated_at").toString().substring(0, 10));
    }

    @Then("user validates Edit Driver full_name response status code {int}")
    public void user_validates_edit_driver_full_name_response_status_code(Integer statusCode) {
        putResponse.then().statusCode(statusCode);
    }

    @Then("user validates Edit Driver full_name response body error message {string}")
    public void user_validates_edit_driver_full_name_response_body_error_message(String errorMessage) {
        String actualErrorMessage = putResponse.body().jsonPath().getString("detail[0].msg");
        Assert.assertEquals(errorMessage, actualErrorMessage);
    }

    @Then("user validates Edit Driver is_staff status code {int}")
    public void user_validates_edit_driver_is_staff_status_code(Integer statusCode) {
        putResponse.then().statusCode(statusCode);
    }

    @Then("user validates updated driver data is_staff is {string} in get call response")
    public void user_validates_updated_driver_data_is_staff_is_in_get_call_response(String is_staff) {
        boolean isStaff = Boolean.parseBoolean(is_staff);
        Assert.assertEquals(isStaff, getResponse.body().jsonPath().get("is_staff"));
    }
}