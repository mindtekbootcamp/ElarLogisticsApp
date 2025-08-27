package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.junit.Assert;
import pojos.CreateDriverRequest;
import pojos.CreateDriverResponse;
import utilities.ConfigReader;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class CreateDriverAPISteps {

    Response postResponse;

    @Given("user sends post api call with data")
    public void user_sends_post_api_call_with_data(DataTable dataTable) {

        Map<String, Object> data=dataTable.asMap(String.class, Object.class);

        CreateDriverRequest createDriverRequest=new CreateDriverRequest();
        createDriverRequest.setDefaultValues();
        createDriverRequest.setFull_name(data.get("full_name").toString());

        postResponse = given().baseUri(ConfigReader.getProperty("ElarAPIBaseURL"))
                .and().header("Accept", "application/json")
                .and().header("Content-Type", "application/json")
                .and().header("Cookie","Access=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJzdHVkZW50QG1pbmR0ZWsiLCJoZWFkZXIiOnsidHlwZSI6IkFjY2VzcyIsImFsZyI6IkhTMjU2In0sImV4cCI6MTc1NjQxMTUyNX0.XEkhSSy9Lw0MYfJDcFWEp_1kt7fXr3QfZW1MzbW_l_8; Refresh=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJzdHVkZW50QG1pbmR0ZWsiLCJoZWFkZXIiOnsidHlwZSI6IlJlZnJlc2giLCJhbGciOiJIUzI1NiJ9LCJleHAiOjE3NTY0MTE1MjV9.MJI55UZgt_SRaA4WDWzXCnzRyVjn9xdlXwDeuv6NRI0")
                .and().body(createDriverRequest) // POJO -> Json = SERIALIZATION
                .and().log().all()
                .when().post("/drivers");
        postResponse.then().log().all();
    }

    @Then("user validates status code {int}")
    public void user_validates_status_code(int statusCode) {
        postResponse.then().statusCode(statusCode);
    }
    @Then("user validates response data matches with request data")
    public void user_validates_response_data_matches_with_request_data() {
        // Get createDriverRequest and validate against postResponse body.
        CreateDriverRequest createDriverRequest = new CreateDriverRequest();
        // Convert postResponse body to Java Object - Deserialization
        CreateDriverResponse createDriverResponse = postResponse.as(CreateDriverResponse.class);

        /* Create Java Object for response body:
         {
            "uuid": "dc0aee63-305f-4f3c-b9cb-787bc550757e",
            "id": 2456,
            "schedule": [],
            "full_name": "Johny Doe",
            "is_staff": false,
            "status": "Off duty",
            "alerts": [],
            "created_at": "2025-08-27T20:19:01.225779Z",
            "updated_at": "2025-08-27T20:19:01.225779Z",
            "driver_local_identifier": "None",
            "contacts_phone": [],
            "contacts_email": [],
            "contacts_viber": [],
            "contacts_other": []
        }
         */
        // Validate full_name and is_staff from request object matches with response java object

        Response getResponse = given().baseUri(ConfigReader.getProperty("ElarAPIBaseURL"))
                .and().header("Accept", "application/json")
                .and().header("Content-Type", "application/json")
                .and().header("Cookie","Access=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJzdHVkZW50QG1pbmR0ZWsiLCJoZWFkZXIiOnsidHlwZSI6IkFjY2VzcyIsImFsZyI6IkhTMjU2In0sImV4cCI6MTc1NjQxMTUyNX0.XEkhSSy9Lw0MYfJDcFWEp_1kt7fXr3QfZW1MzbW_l_8; Refresh=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJzdHVkZW50QG1pbmR0ZWsiLCJoZWFkZXIiOnsidHlwZSI6IlJlZnJlc2giLCJhbGciOiJIUzI1NiJ9LCJleHAiOjE3NTY0MTE1MjV9.MJI55UZgt_SRaA4WDWzXCnzRyVjn9xdlXwDeuv6NRI0")
                .and().body(createDriverResponse)
                .and().log().all()
                .when().post("/drivers");
        getResponse.then().log().all();
        getResponse.then().statusCode(200);
        Assert.assertEquals(createDriverRequest.getFull_name(),createDriverResponse.getFull_name());
        Assert.assertEquals(createDriverRequest.getIs_staff(),createDriverResponse.is_staff());
    }

    @Then("user validates response body error message {string}")
    public void user_validates_response_body_error_message(String errorMessage) {

    }
}
