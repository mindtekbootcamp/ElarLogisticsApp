package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;
import pojos.CreateDriverRequest;
import pojos.CreateDriverResponse;
import utilities.ConfigReader;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class CreateDriverAPISteps {

    Response postResponse;
    Response getResponse;
    CreateDriverRequest createDriverRequest;
    int driverId;

    String token="Access=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9" +
            ".eyJzdWIiOiJzdHVkZW50QG1pbmR0ZWsiLCJoZWFkZXIiOnsidHlwZSI6IkFjY2VzcyIsImFsZyI6IkhTMjU2In0sImV4cCI6MTc1NjQ5ODAzM30" +
            ".M8HHFus3s9fuelqrcTRdMTvsnoXCYB6sXoaHgiGN5dA; " +
            "Refresh=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9" +
            ".eyJzdWIiOiJzdHVkZW50QG1pbmR0ZWsiLCJoZWFkZXIiOnsidHlwZSI6IlJlZnJlc2giLCJhbGciOiJIUzI1NiJ9LCJleHAiOjE3NTY0OTgwMzN9" +
            ".0e4VgyhlRMo3IpvnA6bOL5mX352yrZxdDJ-uo45E6rE";

    @Given("user sends post api call with data")
    public void user_sends_post_api_call_with_data(DataTable dataTable) {

        Map<String, Object> data=dataTable.asMap(String.class, Object.class);


        createDriverRequest=new CreateDriverRequest();
        createDriverRequest.setDefaultValues();
        createDriverRequest.setFull_name(getTableValue(data,"full_name"));
        createDriverRequest.setIs_staff(Boolean.valueOf(getTableValue(data,"is_staff")));
        createDriverRequest.setDriving_license_exp(getTableValue(data,"driving_license_exp"));
        createDriverRequest.setMedical_certification_exp(getTableValue(data,"medical_certification_exp"));

        postResponse = given().baseUri(ConfigReader.getProperty("ElarAPIBaseURL"))
                .and().header("Accept", "application/json")
                .and().header("Content-Type", "application/json")
                .and().header("Cookie",token)
                .and().body(createDriverRequest) // POJO -> Json = SERIALIZATION
                .and().log().all()
                .when().post("/drivers");
        postResponse.then().log().all();
    }

    @Then("user validates status code {int}")
    public void user_validates_status_code(int statusCode) {
        postResponse.then().statusCode(statusCode);
    }

    @When("user gets created driver with get call")
    public void user_gets_created_driver_with_get_call() {
        CreateDriverResponse createDriverResponse = postResponse.as(CreateDriverResponse.class); // DESERIALIZATION
        driverId=createDriverResponse.getId();
         getResponse = given().baseUri(ConfigReader.getProperty("ElarAPIBaseURL"))
                .and().header("Accept", "application/json")
                .and().header("Cookie",token)
                .and().log().all()
                .when().get("/drivers/"+driverId);
        getResponse.then().log().all();
        getResponse.then().statusCode(200);
    }

    @Then("user validates created driver data in get call response")
    public void user_validates_created_driver_data_in_get_call_response() {
        Assert.assertEquals(createDriverRequest.getFull_name(),getResponse.body().jsonPath().get("full_name"));
        Assert.assertEquals(createDriverRequest.getIs_staff(),getResponse.body().jsonPath().get("is_staff"));
    }

    @Then("user validates response body error message {string}")
    public void user_validates_response_body_error_message(String errorMessage) {
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
