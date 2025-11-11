package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pojos.CreateCarrierRequest;
import utilities.APIUtils;
import utilities.DataLoader;
import utilities.DataTableUtils;

public class CreateCarrierAPISteps {

    CreateCarrierRequest createCarrierRequest = DataLoader.createCarrierRequest;

    @Given("user sends Post Driver API call with valid name and abbreviation and 3 carrier types {string}")
    public void user_sends_post_driver_api_call_with_valid_name_and_abbreviation_and_3_carrier_types(String carrier_type) {
        createCarrierRequest.setDefaultValues();
        createCarrierRequest.setCarrier_type(carrier_type);
        APIUtils.postCall(createCarrierRequest, "/carriers");
    }

    @Given("user sends Post Driver API call with {string} carrier_name field")
    public void user_sends_post_driver_api_call_with_carrier_name_field(String carrier_name) {
        createCarrierRequest.setDefaultValues();
        if(carrier_name.contains("null")){
            carrier_name = null;
        }
        createCarrierRequest.setCarrier_name(carrier_name);
        APIUtils.postCall(createCarrierRequest, "/carriers");
    }

    @Given("user sends Post Driver API call with {string} abbreviation field")
    public void user_sends_post_driver_api_call_with_abbreviation_field(String abbreviation) {
        createCarrierRequest.setDefaultValues();
        if(abbreviation.contains("null")){
            abbreviation = null;
        }
        createCarrierRequest.setAbbreviation(abbreviation);
        APIUtils.postCall(createCarrierRequest, "/carriers");
    }

    @Given("user sends Post Driver API call with {string} carrier_type field")
    public void user_sends_post_driver_api_call_with_carrier_type_field(String carrier_type) {
        createCarrierRequest.setDefaultValues();
        if(carrier_type.contains("null")){
            carrier_type = null;
        }
        createCarrierRequest.setCarrier_type(carrier_type);
        APIUtils.postCall(createCarrierRequest, "/carriers");
    }
    @Given("user sends Post Carrier API call with 3 Statuses {string} and valid MC# and DOT#")
    public void user_sends_post_Carrier_api_call_with_3_statuses_and_valid_mc_and_dot(String statusInput) {
        createCarrierRequest.setDefaultValues();
        createCarrierRequest.setStatus(statusInput);
        APIUtils.postCall(createCarrierRequest, "/carriers");
    }
    @Given("user sends Post Carrier API call with {string} MC# field")
    public void user_sends_post_Carrier_api_call_with_mc_field(String mcNum) {
        createCarrierRequest.setDefaultValues();
        createCarrierRequest.setMc_number(mcNum);
        APIUtils.postCall(createCarrierRequest, "/carriers");
    }
    @Given("user sends Post Carrier API call with {string} DOT# field")
    public void user_sends_post_Carrier_api_call_with_dot_field(String dotNum) {
        createCarrierRequest.setDefaultValues();
        createCarrierRequest.setDot_number(dotNum);
        APIUtils.postCall(createCarrierRequest, "/carriers");
    }

    @Then("user validates Post Carrier status code {int}")
    public void user_validates_post_carrier_status_code(Integer statusCode) {
        DataLoader.responseData.get("postResponse").then().statusCode(statusCode);
    }

    @Then("user validates response body has data matched with request data")
    public void user_validates_response_body_has_data_matched_with_request_data() {
        int id = DataLoader.responseData.get("postResponse").body().jsonPath().getInt("id");
        APIUtils.getCall("/carriers/" + id);
        System.out.println("Get response value: " + DataLoader.responseData.get("getResponse").asString());
        String getResponse = DataLoader.responseData.get("getResponse").body().jsonPath().get("carrier_name");
        Assert.assertEquals(createCarrierRequest.getCarrier_name(), DataLoader.responseData.get("getResponse").body().jsonPath().get("carrier_name"));
        Assert.assertEquals(createCarrierRequest.getCarrier_type(), DataLoader.responseData.get("getResponse").body().jsonPath().get("carrier_type"));
        Assert.assertEquals(createCarrierRequest.getAbbreviation(), DataLoader.responseData.get("getResponse").body().jsonPath().get("abbreviation"));
        Assert.assertEquals(createCarrierRequest.getStatus(), DataLoader.responseData.get("getResponse").body().jsonPath().get("status"));
        Assert.assertEquals(createCarrierRequest.getMc_number(), DataLoader.responseData.get("getResponse").body().jsonPath().get("mc_number"));
        Assert.assertEquals(createCarrierRequest.getDot_number(), DataLoader.responseData.get("getResponse").body().jsonPath().get("dot_number"));

    }

    @Then("user validates Post Carrier API call response body error message {string}")
    public void user_validates_post_carrier_api_call_response_body_error_message(String errorMessage) {
        String actualErrorMessage = DataLoader.responseData.get("postResponse").body().jsonPath().getString("detail[0].msg");
        Assert.assertEquals(errorMessage, actualErrorMessage);
    }
}
