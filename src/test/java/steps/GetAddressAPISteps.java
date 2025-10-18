package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.junit.Assert;
import utilities.APIUtils;

import java.util.HashMap;
import java.util.Map;

public class GetAddressAPISteps {

    Response getResponse;

    @Given("user sends Address Get API call with valid order_by {string} parameters and size 50")
    public void user_sends_address_get_api_call_with_valid_order_by_parameters_and_size(String order_by) {
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("order_by", order_by);
        queryParams.put("size", 50);
        APIUtils.getCall(queryParams, "/addresses/");
    }

    @Given("user sends Address Get API call with invalid {string} order_by parameter and size 50")
    public void user_sends_address_get_api_call_with_invalid_order_by_parameter_and_size(String order_by) {
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("order_by", order_by);
        queryParams.put("size", 50);
        APIUtils.getCall(queryParams, "/addresses/");
    }

    @Given("user sends Address Get API call with valid order_by parameter id and valid sizes {int}")
    public void user_sends_address_get_api_call_with_valid_order_by_parameter_id_and_valid_sizes(Integer size) {
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("order_by", "id");
        queryParams.put("size", size);
        APIUtils.getCall(queryParams, "/addresses/");
    }

    @Given("user sends Address Get API call with valid order_by parameter id and invalid smaller sizes {int}")
    public void user_sends_address_get_api_call_with_valid_order_by_parameter_id_and_invalid_smaller_sizes(Integer size) {
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("order_by", "id");
        queryParams.put("size", size);
        APIUtils.getCall(queryParams, "/addresses/");
    }

    @Given("user sends Address Get API call with valid order_by parameter id and invalid larger size {int}")
    public void user_sends_address_get_api_call_with_valid_order_by_parameter_id_and_invalid_larger_size(Integer size) {
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("order_by", "id");
        queryParams.put("size", size);
        APIUtils.getCall(queryParams, "/addresses/");
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
