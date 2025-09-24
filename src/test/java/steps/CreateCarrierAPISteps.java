package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.junit.Assert;
import pojos.CreateCarrierRequest;
import utilities.APIUtils;
import utilities.CarrierAPIUtils;

import java.util.Random;

public class CreateCarrierAPISteps {
    Response postResponse;
    Response getResponse;
    CreateCarrierRequest createCarrierRequest;

    @Given("user sends Post Driver API call with valid name and abbreviation and 3 carrier types {string}")
    public void user_sends_post_driver_api_call_with_valid_name_and_abbreviation_and_3_carrier_types(String carrier_type) {
        createCarrierRequest = new CreateCarrierRequest();
        createCarrierRequest.setDefaultValues();
        createCarrierRequest.setCarrier_type(carrier_type);
        postResponse = APIUtils.postCall(createCarrierRequest, "/carriers");
    }
    @Given("user sends Post Driver API call with {string} carrier_name field")
    public void user_sends_post_driver_api_call_with_carrier_name_field(String carrier_name) {
        createCarrierRequest = new CreateCarrierRequest();
        createCarrierRequest.setDefaultValues();
        createCarrierRequest.setCarrier_name(carrier_name);
        postResponse = APIUtils.postCall(createCarrierRequest, "/carriers");
    }
    @Given("user sends Post Driver API call with null carrier_name field")
    public void user_sends_post_driver_api_call_with_null_carrier_name_field() {
        createCarrierRequest = new CreateCarrierRequest();
        createCarrierRequest.setDefaultValues();
        createCarrierRequest.setCarrier_name(null);
        postResponse = APIUtils.postCall(createCarrierRequest, "/carriers");
    }
    @Given("user sends Post Driver API call with {string} abbreviation field")
    public void user_sends_post_driver_api_call_with_abbreviation_field(String abbreviation) {
        createCarrierRequest = new CreateCarrierRequest();
        createCarrierRequest.setDefaultValues();
        createCarrierRequest.setAbbreviation(abbreviation);
        postResponse = APIUtils.postCall(createCarrierRequest, "/carriers");
    }
    @Given("user sends Post Driver API call with longer than 3 characters abbreviation field")
    public void user_sends_post_driver_api_call_with_longer_than_3_characters_abbreviation_field() {
        Random random = new Random();
        String randomAbr = random.nextInt(9999)+"";
        createCarrierRequest = new CreateCarrierRequest();
        createCarrierRequest.setDefaultValues();
        createCarrierRequest.setAbbreviation(randomAbr);
        postResponse = APIUtils.postCall(createCarrierRequest, "/carriers");
    }
    @Given("user sends Post Driver API call with null abbreviation field")
    public void user_sends_post_driver_api_call_with_null_abbreviation_field() {
        createCarrierRequest = new CreateCarrierRequest();
        createCarrierRequest.setDefaultValues();
        createCarrierRequest.setAbbreviation(null);
        postResponse = APIUtils.postCall(createCarrierRequest, "/carriers");
    }
    @Given("user sends Post Driver API call with {string} carrier_type field")
    public void user_sends_post_driver_api_call_with_carrier_type_field(String carrier_type) {
        createCarrierRequest = new CreateCarrierRequest();
        createCarrierRequest.setDefaultValues();
        createCarrierRequest.setCarrier_type(carrier_type);
        postResponse = APIUtils.postCall(createCarrierRequest, "/carriers");
    }
    @Given("user sends Post Driver API call with random string carrier_type field")
    public void user_sends_post_driver_api_call_with_random_string_carrier_type_field() {
        createCarrierRequest = new CreateCarrierRequest();
        createCarrierRequest.setDefaultValues();
        createCarrierRequest.setCarrier_type(CarrierAPIUtils.randomNumberGenerator());
        postResponse = APIUtils.postCall(createCarrierRequest, "/carriers");
    }
    @Given("user sends Post Driver API call with null carrier_type field")
    public void user_sends_post_driver_api_call_with_null_carrier_type_field() {
        createCarrierRequest = new CreateCarrierRequest();
        createCarrierRequest.setDefaultValues();
        createCarrierRequest.setCarrier_type(null);
        postResponse = APIUtils.postCall(createCarrierRequest, "/carriers");
    }
    @Then("user validates Post Carrier status code {int}")
    public void user_validates_post_carrier_status_code(Integer statusCode) {
        postResponse.then().statusCode(statusCode);
    }
    @Then("user validates response body has data matched with request data")
    public void user_validates_response_body_has_data_matched_with_request_data() {
        int id = postResponse.body().jsonPath().getInt("id");
        getResponse = APIUtils.getCall("/carriers/" + id);
        Assert.assertEquals(createCarrierRequest.getCarrier_name(), getResponse.body().jsonPath().get("carrier_name"));
        Assert.assertEquals(createCarrierRequest.getCarrier_type(), getResponse.body().jsonPath().get("carrier_type"));
        Assert.assertEquals(createCarrierRequest.getAbbreviation(), getResponse.body().jsonPath().get("abbreviation"));
    }
    @Then("user validates Post Carrier API call response body error message {string}")
    public void user_validates_post_carrier_api_call_response_body_error_message(String errorMessage) {
        String actualErrorMessage=postResponse.body().jsonPath().getString("detail[0].msg");
        Assert.assertEquals(errorMessage,actualErrorMessage);
    }
}
