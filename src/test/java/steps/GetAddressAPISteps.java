package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.junit.Assert;
import utilities.ConfigReader;

import static io.restassured.RestAssured.given;


public class GetAddressAPISteps {

    Response getResponse;

    String token = ConfigReader.getProperty("ElarAPIToken");

    @Given("user sends Address Get API call with valid order_by {string} parameters and size 50")
    public void user_sends_address_get_api_call_with_valid_order_by_parameters_and_size(String order_by) {
        getResponse = given().baseUri(ConfigReader.getProperty("ElarAPIBaseURL"))
                .and().header("Accept", "application/json")
                .and().header("Content-Type", "application/json")
                .and().header("Cookie", token)
                .and().queryParam("order_by",order_by)
                .and().queryParam("size", 50)
                .and().log().all()
                .when().get("/addresses/");
        getResponse.then().log().all();
    }
    @Given("user sends Address Get API call with invalid {string} order_by parameter and size 50")
    public void user_sends_address_get_api_call_with_invalid_order_by_parameter_and_size(String order_by) {
        getResponse = given().baseUri(ConfigReader.getProperty("ElarAPIBaseURL"))
                .and().header("Accept", "application/json")
                .and().header("Content-Type", "application/json")
                .and().header("Cookie", token)
                .and().queryParam("order_by",order_by)
                .and().queryParam("size", 50)
                .and().log().all()
                .when().get("/addresses/");
        getResponse.then().log().all();
    }

    @Given("user sends Address Get API call with valid order_by parameter id and valid sizes {int}")
    public void user_sends_address_get_api_call_with_valid_order_by_parameter_id_and_valid_sizes(Integer size) {
        getResponse = given().baseUri(ConfigReader.getProperty("ElarAPIBaseURL"))
                .and().header("Accept", "application/json")
                .and().header("Content-Type", "application/json")
                .and().header("Cookie", token)
                .and().queryParam("order_by","id")
                .and().queryParam("size", size)
                .and().log().all()
                .when().get("/addresses/");
        getResponse.then().log().all();
    }

    @Given("user sends Address Get API call with valid order_by parameter id and invalid smaller sizes {int}")
    public void user_sends_address_get_api_call_with_valid_order_by_parameter_id_and_invalid_smaller_sizes(Integer size) {
        getResponse = given().baseUri(ConfigReader.getProperty("ElarAPIBaseURL"))
                .and().header("Accept", "application/json")
                .and().header("Content-Type", "application/json")
                .and().header("Cookie", token)
                .and().queryParam("order_by","id")
                .and().queryParam("size", size)
                .and().log().all()
                .when().get("/addresses/");
        getResponse.then().log().all();
    }

    @Given("user sends Address Get API call with valid order_by parameter id and invalid larger size {int}")
    public void user_sends_address_get_api_call_with_valid_order_by_parameter_id_and_invalid_larger_size(Integer size) {
        getResponse = given().baseUri(ConfigReader.getProperty("ElarAPIBaseURL"))
                .and().header("Accept", "application/json")
                .and().header("Content-Type", "application/json")
                .and().header("Cookie", token)
                .and().queryParam("order_by","id")
                .and().queryParam("size", size)
                .and().log().all()
                .when().get("/addresses/");
        getResponse.then().log().all();
    }

    @Then("user validates get address status code {int}")
    public void user_validates_get_address_status_code(Integer statusCode) {
        getResponse.then().statusCode(statusCode);
    }

    @Then("user validates get address response body error message {string}")
    public void user_validates_get_address_response_body_error_message(String errorMessage) {
        String actualErrorMessage = getResponse.body().jsonPath().getString("detail[0].msg");
        Assert.assertEquals(errorMessage, actualErrorMessage);
    }
}
