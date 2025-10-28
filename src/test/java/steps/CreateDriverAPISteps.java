package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;
import pojos.CreateDriverRequest;
import pojos.CreateDriverResponse;
import utilities.APIUtils;
import utilities.DataLoader;
import utilities.DataTableUtils;

import java.util.Map;

public class CreateDriverAPISteps {

    CreateDriverRequest createDriverRequest = DataLoader.createDriverRequest;
    int driverId;

    @Given("user sends post api call with data")
    public void user_sends_post_api_call_with_data(DataTable dataTable) {
        Map<String, Object> data = dataTable.asMap(String.class, Object.class);
        createDriverRequest.setDefaultValues();
        createDriverRequest.setFull_name(DataTableUtils.getTableValue(data, "full_name"));
        createDriverRequest.setIs_staff(Boolean.valueOf(DataTableUtils.getTableValue(data, "is_staff")));
        createDriverRequest.setDriving_license_exp(DataTableUtils.getTableValue(data, "driving_license_exp"));
        createDriverRequest.setMedical_certification_exp(DataTableUtils.getTableValue(data, "medical_certification_exp"));
        APIUtils.postCall(createDriverRequest, "/drivers");
        if(DataLoader.responseData.get("postResponse").getStatusCode()==200) {
            CreateDriverResponse createDriverResponse = DataLoader.responseData.get("postResponse").as(CreateDriverResponse.class); // DESERIALIZATION
            driverId = createDriverResponse.getId();
            DataLoader.dataLoader.put("driverId", driverId);
        }
    }

    @Then("user validates status code {int}")
    public void user_validates_status_code(int statusCode) {
        DataLoader.responseData.get("postResponse").then().statusCode(statusCode);
    }

    @When("user gets created driver with get call")
    public void user_gets_created_driver_with_get_call() {
        CreateDriverResponse createDriverResponse = DataLoader.responseData.get("postResponse").as(CreateDriverResponse.class); // DESERIALIZATION
        driverId = createDriverResponse.getId();
        APIUtils.getCall("/drivers/" + driverId);
    }

    @Then("user validates created driver data in get call response")
    public void user_validates_created_driver_data_in_get_call_response() {
        Assert.assertEquals(createDriverRequest.getFull_name(), DataLoader.responseData.get("getResponse").body().jsonPath().get("full_name"));
        Assert.assertEquals(createDriverRequest.getIs_staff(), DataLoader.responseData.get("getResponse").body().jsonPath().get("is_staff"));
    }

    @Then("user validates response body error message {string}")
    public void user_validates_response_body_error_message(String errorMessage) {
        String actualErrorMessage = DataLoader.responseData.get("postResponse").body().jsonPath().getString("detail[0].msg");
        Assert.assertEquals(errorMessage, actualErrorMessage);
    }
}
