package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;
import pojos.CreateAddressRequest;
import pojos.CreateAddressResponse;
import utilities.APIUtils;
import utilities.DataLoader;
import utilities.DataTableUtils;

import java.util.Map;


public class CreateAddressAPISteps {

    CreateAddressRequest createAddressRequest = DataLoader.createAddressRequest;
    int addressId;

    @Given("user sends create address post api call with data")
    public void user_sends_create_address_post_api_call_with_data(DataTable dataTable) {
        Map<String, Object> data = dataTable.asMap(String.class, Object.class);
        createAddressRequest = new CreateAddressRequest();
        createAddressRequest.setDefaultValues();
        createAddressRequest.setAddress(DataTableUtils.getTableValue(data, "address"));
        createAddressRequest.setCity(DataTableUtils.getTableValue(data, "city"));
        createAddressRequest.setState(DataTableUtils.getTableValue(data, "state"));
        createAddressRequest.setZip_code(DataTableUtils.getTableValue(data, "zip_code"));
        createAddressRequest.setName(DataTableUtils.getTableValue(data, "name"));
        APIUtils.postCall(createAddressRequest, "/addresses");
    }

    @Then("user validates create address status code {int}")
    public void user_validates_create_address_status_code(int statusCode) {
        DataLoader.responseData.get("postResponse").then().statusCode(statusCode);
    }

    @When("user gets created address with get call")
    public void user_gets_created_address_with_get_call() {
        CreateAddressResponse createAddressResponse = DataLoader.responseData.get("postResponse").as(CreateAddressResponse.class); // DESERIALIZATION
        addressId = createAddressResponse.getId();
        APIUtils.getCall("/addresses/" + addressId);
        DataLoader.responseData.get("getResponse").then().statusCode(200);
    }

    @Then("user validates created address data in get call response")
    public void user_validates_created_address_data_in_get_call_response() {
        Assert.assertEquals(createAddressRequest.getAddress(), DataLoader.responseData.get("getResponse").body().jsonPath().get("address"));
        Assert.assertEquals(createAddressRequest.getName(), DataLoader.responseData.get("getResponse").body().jsonPath().get("name"));
    }

    @Then("user validates create address response body error message {string}")
    public void user_validates_create_address_response_body_error_message(String errorMessage) {
        String actualErrorMessage = DataLoader.responseData.get("postResponse").body().jsonPath().getString("detail[0].msg");
        Assert.assertEquals(errorMessage, actualErrorMessage);
    }

}
