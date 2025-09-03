package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import pojos.CreateAddressRequest;

import java.util.Map;

public class CreateAddressAPISteps {

    public String getTableValue(Map<String, Object> data, String key){
        String name;
        if(data.get(key)==null) name="";
        else if(data.get(key).equals("null")) name=null;
        else name = data.get(key).toString();
        return name;
    }

    Response postResponse;
    Response getResponse;
    CreateAddressRequest createAddressRequest;
    int id;

    String token = "Access=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9" +
            ".eyJzdWIiOiJzdHVkZW50QG1pbmR0ZWsiLCJoZWFkZXIiOnsidHlwZSI6IkFjY2VzcyIsImFsZyI6IkhTMjU2In0sImV4cCI6MTc1Njk0MTM4MH0" +
            ".ozK7vQCTOgwIvxHgvg5dkM3cayjMN5rNlB6LOHmPDTA;" +
            " Refresh=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9" +
            ".eyJzdWIiOiJzdHVkZW50QG1pbmR0ZWsiLCJoZWFkZXIiOnsidHlwZSI6IlJlZnJlc2giLCJhbGciOiJIUzI1NiJ9LCJleHAiOjE3NTY5NDEzODB9" +
            ".xxxaLLElVV7iXOdMxSs72Bxs8mTlX8MKJofujT-61p4";


    @Given("user sends create address post api call with data")
    public void user_sends_create_address_post_api_call_with_data(DataTable dataTable) {

        Map<String, Object> data=dataTable.asMap(String.class, Object.class);

        CreateAddressRequest = new CreateAddressRequest();

    }
    @Then("user validates create address status code {int}")
    public void user_validates_create_address_status_code(int statusCode) {

    }
    @When("user gets created address with get call")
    public void user_gets_created_address_with_get_call() {

    }
    @Then("user validates created address data in get call response")
    public void user_validates_created_address_data_in_get_call_response() {

    }

    @Then("user validates create address response body error message {string}")
    public void user_validates_create_address_response_body_error_message(String errorMessage) {

    }
}
