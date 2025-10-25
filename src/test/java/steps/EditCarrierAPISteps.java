package steps;

import com.github.wnameless.json.flattener.JsonFlattener;
import com.github.wnameless.json.unflattener.JsonUnflattener;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import utilities.APIUtils;
import utilities.DataLoader;
import utilities.JsonUtils;

import java.util.Map;

public class EditCarrierAPISteps {

    String editCarriers = JsonUtils.getJson("EditCarriersRequest");
    Map<String, Object> jsonMap = JsonFlattener.flattenAsMap(editCarriers);
    int carrierID = DataLoader.responseData.get("postResponse").body().jsonPath().getInt("id");

    @Given("user sends put carrier API call with valid data")
    public void user_sends_put_carrier_api_call_with_valid_data() {
        jsonMap = JsonUtils.getUpdatedCarrierPutRequestBody();
        editCarriers = JsonUnflattener.unflatten(jsonMap);
        APIUtils.putCall(editCarriers, "/carriers/" + carrierID);
    }

    @Given("user sends Put Carrier API call with {string} carrier_name field")
    public void user_sends_put_carrier_api_call_with_carrier_name_field(String carrier_name) {
        jsonMap = JsonUtils.getUpdatedCarrierPutRequestBody();
        jsonMap.put("carrier_name", carrier_name);
        editCarriers = JsonUnflattener.unflatten(jsonMap);
        APIUtils.putCall(editCarriers, "/carriers/" + carrierID);
    }

    @Given("user sends Put Carriers API call with {string} mc_number field")
    public void user_sends_put_carriers_api_call_with_mc_number_field(String mc_number) {
        jsonMap = JsonUtils.getUpdatedCarrierPutRequestBody();
        jsonMap.put("mc_number", mc_number);
        editCarriers = JsonUnflattener.unflatten(jsonMap);
        APIUtils.putCall(editCarriers, "/carriers/" + carrierID);
    }

    @Given("user sends Put Carriers API call with {string} dot_number field")
    public void user_sends_put_carriers_api_call_with_dot_number_field(String dot_number) {
        jsonMap = JsonUtils.getUpdatedCarrierPutRequestBody();
        jsonMap.put("dot_number", dot_number);
        editCarriers = JsonUnflattener.unflatten(jsonMap);
        APIUtils.putCall(editCarriers, "/carriers/" + carrierID);
    }

    @Then("user validates Put Carrier status code {int}")
    public void user_validates_put_carrier_status_code(Integer status_code) {
        DataLoader.responseData.get("putResponse").then().statusCode(status_code);
    }

    @Then("user validates Put response body has data matched with request data")
    public void user_validates_put_response_body_has_data_matched_with_request_data() {
        APIUtils.getCall("/carriers/" + carrierID);
        Assert.assertEquals(jsonMap.get("carrier_name"), DataLoader.responseData.get("getResponse").body().jsonPath().get("carrier_name"));
        Assert.assertEquals(jsonMap.get("mc_number"), DataLoader.responseData.get("getResponse").body().jsonPath().get("mc_number"));
        Assert.assertEquals(jsonMap.get("dot_number"), DataLoader.responseData.get("getResponse").body().jsonPath().get("dot_number"));
    }

    @Then("user validates Put Carrier API call response body error message {string}")
    public void user_validates_put_carrier_api_call_response_body_error_message(String errorMessage) {
        Assert.assertEquals(errorMessage, DataLoader.responseData.get("putResponse").body().jsonPath().getString("detail[0].msg"));
    }
}
