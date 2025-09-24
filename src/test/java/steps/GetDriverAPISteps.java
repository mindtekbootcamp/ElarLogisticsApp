package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.junit.Assert;
import utilities.ConfigReader;
import utilities.Constants;

import static io.restassured.RestAssured.given;

public class GetDriverAPISteps {
    Response getResponse;

    String token = ConfigReader.getProperty("ElarAPIToken");
    
    

    @Given("user sends Get Driver API call with valid is_staff {string} parameters and valid order_by {string} and size {int} parameters")
    public void user_sends_get_driver_api_call_with_valid_is_staff_parameters_and_valid_order_by_and_size_parameters(String is_staff, String order_by, Integer size) {
        boolean isStaff = Boolean.parseBoolean(is_staff);
        getResponse = given().baseUri(ConfigReader.getProperty("ElarAPIBaseURL"))
                .and().header("Accept", "application/json")
                .and().header("Cookie", token)
                .and().queryParam("is_staff", isStaff)
                .and().queryParam("order_by", order_by)
                .and().queryParam("size", size)
                .and().log().all()
                .when().get("/drivers");
        getResponse.then().log().all();
    }
    @Given("user sends Get Driver API call with {string} is_staff parameter and valid order_by {string} and size {int} parameters")
    public void user_sends_get_driver_api_call_with_is_staff_parameter_and_valid_order_by_parameter_and_size_parameters(String is_staff, String order_by, Integer size) {
        getResponse = given().baseUri(ConfigReader.getProperty("ElarAPIBaseURL"))
                .and().header("Accept", "application/json")
                .and().header("Cookie", token)
                .and().queryParam("is_staff", is_staff)
                .and().queryParam("order_by", order_by)
                .and().queryParam("size", size)
                .and().log().all()
                .when().get("/drivers");
        getResponse.then().log().all();
    }
    @Given("user sends Get Driver API call with valid is_staff parameter and invalid order_by {string} parameter and valid size {int} parameter")
    public void user_sends_get_driver_api_call_with_valid_is_staff_parameter_and_invalid_order_by_parameter_and_valid_size_parameter(String order_by, Integer size) {
        getResponse = given().baseUri(ConfigReader.getProperty("ElarAPIBaseURL"))
                .and().header("Accept", "application/json")
                .and().header("Cookie", token)
                .and().queryParam("is_staff", Constants.ISSTAFF_TRUE)
                .and().queryParam("order_by", order_by)
                .and().queryParam("size", size)
                .and().log().all()
                .when().get("/drivers");
        getResponse.then().log().all();
    }
    @Given("user sends Get Driver API call with valid is_staff parameter and {string} order_by parameter and valid size {int} parameter")
    public void user_sends_get_driver_api_call_with_valid_is_staff_parameter_and_order_by_parameter_and_valid_size_parameter(String order_by, Integer size) {
        getResponse = given().baseUri(ConfigReader.getProperty("ElarAPIBaseURL"))
                .and().header("Accept", "application/json")
                .and().header("Cookie", token)
                .and().queryParam("is_staff", Constants.ISSTAFF_TRUE)
                .and().queryParam("order_by", order_by)
                .and().queryParam("size", size)
                .and().log().all()
                .when().get("/drivers");
        getResponse.then().log().all();
    }

    @Given("user sends Get Driver API call with valid is_staff and valid order_by {string} parameters and {string} size parameter")
    public void user_sends_get_driver_api_call_with_valid_is_staff_and_valid_order_by_parameters_and_size_parameter(String order_by, String size) {
        getResponse = given().baseUri(ConfigReader.getProperty("ElarAPIBaseURL"))
                .and().header("Accept", "application/json")
                .and().header("Cookie", token)
                .and().queryParam("is_staff", Constants.ISSTAFF_TRUE)
                .and().queryParam("order_by", order_by)
                .and().queryParam("size", size)
                .and().log().all()
                .when().get("/drivers");
        getResponse.then().log().all();
    }
    @Given("user sends Get Driver API call with valid is_staff and valid order_by {string} parameters and smaller sizes {int}")
    public void user_sends_get_driver_api_call_with_valid_is_staff_and_valid_order_by_parameters_and_smaller_sizes(String order_by, Integer size) {
        getResponse = given().baseUri(ConfigReader.getProperty("ElarAPIBaseURL"))
                .and().header("Accept", "application/json")
                .and().header("Cookie", token)
                .and().queryParam("is_staff", Constants.ISSTAFF_TRUE)
                .and().queryParam("order_by", order_by)
                .and().queryParam("size", size)
                .and().log().all()
                .when().get("/drivers");
        getResponse.then().log().all();
    }
    @Given("user sends Get Driver API call with valid is_staff and valid order_by {string} parameters and invalid larger size {int}")
    public void user_sends_get_driver_api_call_with_valid_is_staff_and_valid_order_by_parameters_and_invalid_larger_size(String order_by, Integer size) {
        getResponse = given().baseUri(ConfigReader.getProperty("ElarAPIBaseURL"))
                .and().header("Accept", "application/json")
                .and().header("Cookie", token)
                .and().queryParam("is_staff", Constants.ISSTAFF_TRUE)
                .and().queryParam("order_by", order_by)
                .and().queryParam("size", size)
                .and().log().all()
                .when().get("/drivers");
        getResponse.then().log().all();
    }
    @Given("user sends Get Driver API call with valid is_staff and valid order_by {string} parameters and min and max sizes {int}")
    public void user_sends_get_driver_api_call_with_valid_is_staff_and_valid_order_by_parameters_and_min_and_max_sizes(String order_by, Integer size) {
        getResponse = given().baseUri(ConfigReader.getProperty("ElarAPIBaseURL"))
                .and().header("Accept", "application/json")
                .and().header("Cookie", token)
                .and().queryParam("is_staff", Constants.ISSTAFF_TRUE)
                .and().queryParam("order_by", order_by)
                .and().queryParam("size", size)
                .and().log().all()
                .when().get("/drivers");
        getResponse.then().log().all();
    }
    @Then("user validates Get Driver status code {int}")
    public void user_validates_get_driver_status_code(Integer statusCode) {
        getResponse.then().statusCode(statusCode);
    }
    @Then("user validates Get Driver response body error message {string}")
    public void user_validates_get_driver_response_body_error_message(String errorMessage) {
        String actualErrorMessage = getResponse.body().jsonPath().getString("detail[0].msg");
        Assert.assertEquals(errorMessage, actualErrorMessage);
    }
}
