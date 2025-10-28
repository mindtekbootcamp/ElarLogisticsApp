package steps;

import io.cucumber.java.en.Given;
import pojos.CreateCarrierRequest;
import utilities.APIUtils;
import utilities.CarrierUtils;
import utilities.DataLoader;

public class CreateCarrierAPI2Steps {

    CreateCarrierRequest createCarrierRequest = DataLoader.createCarrierRequest;

    @Given("user sends Post Carrier API call with 3 Statuses {string} and valid MC# and DOT#")
    public void user_sends_post_Carrier_api_call_with_3_statuses_and_valid_mc_and_dot(String statusInput) {
        createCarrierRequest.setDefaultValues();
        createCarrierRequest.setStatus(statusInput);
        APIUtils.postCall(createCarrierRequest, "/carriers");
    }

    @Given("user sends Post Carrier API call with {string} characters in MC# field")
    public void user_sends_post_Carrier_api_call_with_characters_in_mc_field(String mcNum) {
        createCarrierRequest.setDefaultValues();
        createCarrierRequest.setMc_number(mcNum);
        APIUtils.postCall(createCarrierRequest, "/carriers");
    }

    @Given("user sends Post Carrier API call with less than 4 characters in MC# field")
    public void user_sends_post_Carrier_api_call_with_less_than_4_characters_in_mc_field() {
        createCarrierRequest.setDefaultValues();
        createCarrierRequest.setMc_number(CarrierUtils.randomThreeDigitGenerator());
        APIUtils.postCall(createCarrierRequest, "/carriers");
    }

    @Given("user sends Post Carrier API call with more than 10 characters in MC# field")
    public void user_sends_post_Carrier_api_call_with_more_than_10_characters_in_mc_field() {
        createCarrierRequest.setDefaultValues();
        createCarrierRequest.setMc_number(CarrierUtils.randomNumberGenerator() + CarrierUtils.randomNumberGenerator() + CarrierUtils.randomNumberGenerator());
        APIUtils.postCall(createCarrierRequest, "/carriers");
    }

    @Given("user sends Post Carrier API call with null in MC# field")
    public void user_sends_post_Carrier_api_call_with_null_in_mc_field() {
        createCarrierRequest.setDefaultValues();
        createCarrierRequest.setMc_number(null);
        APIUtils.postCall(createCarrierRequest, "/carriers");
    }

    @Given("user sends Post Carrier API call with {string} characters in DOT# field")
    public void user_sends_post_Carrier_api_call_with_characters_in_dot_field(String dotNum) {
        createCarrierRequest.setDefaultValues();
        createCarrierRequest.setDot_number(dotNum);
        APIUtils.postCall(createCarrierRequest, "/carriers");
    }

    @Given("user sends Post Carrier API call with less than 4 characters in DOT# field")
    public void user_sends_post_Carrier_api_call_with_less_than_4_characters_in_dot_field() {
        createCarrierRequest.setDefaultValues();
        createCarrierRequest.setDot_number(CarrierUtils.randomThreeDigitGenerator());
        APIUtils.postCall(createCarrierRequest, "/carriers");
    }

    @Given("user sends Post Carrier API call with more than 10 characters in DOT# field")
    public void user_sends_post_Carrier_api_call_with_more_than_10_characters_in_dot_field() {
        createCarrierRequest.setDefaultValues();
        createCarrierRequest.setDot_number(CarrierUtils.randomNumberGenerator() + CarrierUtils.randomNumberGenerator() + CarrierUtils.randomNumberGenerator());
        APIUtils.postCall(createCarrierRequest, "/carriers");
    }

    @Given("user sends Post Carrier API call with null in DOT# field")
    public void user_sends_post_Carrier_api_call_with_null_in_dot_field() {
        createCarrierRequest.setDefaultValues();
        createCarrierRequest.setDot_number(null);
        APIUtils.postCall(createCarrierRequest, "/carriers");
    }
}
