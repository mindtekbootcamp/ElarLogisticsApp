package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.junit.Assert;
import utilities.APIUtils;
import utilities.Constants;

import java.util.HashMap;
import java.util.Map;

public class GetDriverAPISteps {

    Response getResponse;

    @Given("user sends Get Driver API call with valid is_staff {string} parameters and valid order_by {string} and size {int} parameters")
    public void user_sends_get_driver_api_call_with_valid_is_staff_parameters_and_valid_order_by_and_size_parameters(String is_staff, String order_by, Integer size) {
        boolean isStaff = Boolean.parseBoolean(is_staff);
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("is_staff", isStaff);
        queryParams.put("order_by", order_by);
        queryParams.put("size", size);
        APIUtils.getCall(queryParams, "/drivers");
    }

    @Given("user sends Get Driver API call with {string} is_staff parameter and valid order_by {string} and size {int} parameters")
    public void user_sends_get_driver_api_call_with_is_staff_parameter_and_valid_order_by_parameter_and_size_parameters(String is_staff, String order_by, Integer size) {
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("is_staff", is_staff);
        queryParams.put("order_by", order_by);
        queryParams.put("size", size);
        APIUtils.getCall(queryParams, "/drivers");
    }

    @Given("user sends Get Driver API call with valid is_staff parameter and invalid order_by {string} parameter and valid size {int} parameter")
    public void user_sends_get_driver_api_call_with_valid_is_staff_parameter_and_invalid_order_by_parameter_and_valid_size_parameter(String order_by, Integer size) {
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("is_staff", Constants.ISSTAFF_TRUE);
        queryParams.put("order_by", order_by);
        queryParams.put("size", size);
        APIUtils.getCall(queryParams, "/drivers");
    }

    @Given("user sends Get Driver API call with valid is_staff parameter and {string} order_by parameter and valid size {int} parameter")
    public void user_sends_get_driver_api_call_with_valid_is_staff_parameter_and_order_by_parameter_and_valid_size_parameter(String order_by, Integer size) {
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("is_staff", Constants.ISSTAFF_TRUE);
        queryParams.put("order_by", order_by);
        queryParams.put("size", size);
        APIUtils.getCall(queryParams, "/drivers");
    }

    @Given("user sends Get Driver API call with valid is_staff and valid order_by {string} parameters and {string} size parameter")
    public void user_sends_get_driver_api_call_with_valid_is_staff_and_valid_order_by_parameters_and_size_parameter(String order_by, String size) {
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("is_staff", Constants.ISSTAFF_TRUE);
        queryParams.put("order_by", order_by);
        queryParams.put("size", size);
        APIUtils.getCall(queryParams, "/drivers");
    }

    @Given("user sends Get Driver API call with valid is_staff and valid order_by {string} parameters and smaller sizes {int}")
    public void user_sends_get_driver_api_call_with_valid_is_staff_and_valid_order_by_parameters_and_smaller_sizes(String order_by, Integer size) {
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("is_staff", Constants.ISSTAFF_TRUE);
        queryParams.put("order_by", order_by);
        queryParams.put("size", size);
        APIUtils.getCall(queryParams, "/drivers");
    }

    @Given("user sends Get Driver API call with valid is_staff and valid order_by {string} parameters and invalid larger size {int}")
    public void user_sends_get_driver_api_call_with_valid_is_staff_and_valid_order_by_parameters_and_invalid_larger_size(String order_by, Integer size) {
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("is_staff", Constants.ISSTAFF_TRUE);
        queryParams.put("order_by", order_by);
        queryParams.put("size", size);
        APIUtils.getCall(queryParams, "/drivers");
    }

    @Given("user sends Get Driver API call with valid is_staff and valid order_by {string} parameters and min and max sizes {int}")
    public void user_sends_get_driver_api_call_with_valid_is_staff_and_valid_order_by_parameters_and_min_and_max_sizes(String order_by, Integer size) {
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("is_staff", Constants.ISSTAFF_TRUE);
        queryParams.put("order_by", order_by);
        queryParams.put("size", size);
        APIUtils.getCall(queryParams, "/drivers");
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
