package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;
import pojos.CreateAddressRequest;
import pojos.CreateAddressResponse;
import pojos.CreateDriverRequest;
import pojos.CreateDriverResponse;
import utilities.ConfigReader;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class CreateAddressAPISteps {

    Response postResponse;
    Response getResponse;
    CreateAddressRequest createAddressRequest;
    int addressId;

    String token = "Access=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9" +
            ".eyJzdWIiOiJzdHVkZW50QG1pbmR0ZWsiLCJoZWFkZXIiOnsidHlwZSI6IkFjY2VzcyIsImFsZyI6IkhTMjU2In0sImV4cCI6MTc1NzIxNDI0Mn0" +
            ".mxufEz-qzir8QaYPiCbMBKnCWtemcNZRtyn463Fjct8; Refresh=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9" +
            ".eyJzdWIiOiJzdHVkZW50QG1pbmR0ZWsiLCJoZWFkZXIiOnsidHlwZSI6IlJlZnJlc2giLCJhbGciOiJIUzI1NiJ9LCJleHAiOjE3NTcyMTQyNDJ9" +
            ".APyA8k-Npr5SgXRH-V3H_5pckg2rtfQvrNLo44_lhxk";


    @Given("user sends create address post api call with data")
    public void user_sends_create_address_post_api_call_with_data(DataTable dataTable) {
        Map<String, Object> data = dataTable.asMap(String.class, Object.class);

        createAddressRequest = new CreateAddressRequest();
        createAddressRequest.setDefaultValues();
        createAddressRequest.setAddress(getTableValue(data,"address"));
        createAddressRequest.setCity(getTableValue(data,"city"));
        createAddressRequest.setState(getTableValue(data,"state"));
        createAddressRequest.setZip_code(getTableValue(data,"zip_code"));
        createAddressRequest.setName(getTableValue(data,"name"));

        postResponse = given().baseUri(ConfigReader.getProperty("ElarAPIBaseURL"))
                .and().header("Accept", "application/json")
                .and().header("Content-Type", "application/json")
                .and().header("Cookie",token)
                .and().body(createAddressRequest ) // POJO -> Json = SERIALIZATION
                .and().log().all()
                .when().post("/addresses");
        postResponse.then().log().all();
    }
    @Then("user validates create address status code {int}")
    public void user_validates_create_address_status_code(int statusCode) {
        postResponse.then().statusCode(statusCode);
    }
    @When("user gets created address with get call")
    public void user_gets_created_address_with_get_call() {
        CreateAddressResponse createAddressResponse = postResponse.as(CreateAddressResponse.class); // DESERIALIZATION
        addressId=createAddressResponse.getId();
        getResponse = given().baseUri(ConfigReader.getProperty("ElarAPIBaseURL"))
                .and().header("Accept", "application/json")
                .and().header("Cookie",token)
                .and().log().all()
                .when().get("/addresses/"+addressId);
        getResponse.then().log().all();
        getResponse.then().statusCode(200);
    }
    @Then("user validates created address data in get call response")
    public void user_validates_created_address_data_in_get_call_response() {
        Assert.assertEquals(createAddressRequest.getAddress(),getResponse.body().jsonPath().get("address"));
        Assert.assertEquals(createAddressRequest.getName(),getResponse.body().jsonPath().get("name"));
    }

    @Then("user validates create address response body error message {string}")
    public void user_validates_create_address_response_body_error_message(String errorMessage) {
        String actualErrorMessage=postResponse.body().jsonPath().getString("detail[0].msg");
        Assert.assertEquals(errorMessage,actualErrorMessage);
    }
    public String getTableValue(Map<String, Object> data, String key){
        String name;
        if(data.get(key)==null) name="";
        else if(data.get(key).equals("null")) name=null;
        else name = data.get(key).toString();
        return name;
    }
}
