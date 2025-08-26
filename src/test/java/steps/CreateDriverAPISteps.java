package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import utilities.ConfigReader;

import static io.restassured.RestAssured.given;

public class CreateDriverAPISteps {

    @Given("user sends post api call with data")
    public void user_sends_post_api_call_with_data() {

        Response postResponse = given().baseUri(ConfigReader.getProperty("ElarAPIBaseURL"))
                .and().header("Accept", "application/json")
                .and().header("Content-Type", "application/json")
                .and().header("Cookie","Access=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJzdHVkZW50QG1pbmR0ZWsiLCJoZWFkZXIiOnsidHlwZSI6IkFjY2VzcyIsImFsZyI6IkhTMjU2In0sImV4cCI6MTc1NjMyNTA3MH0.MpcsRReAOh9392Y_SsZaQyJm0WduoRKUa8n576dIv2E; Refresh=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJzdHVkZW50QG1pbmR0ZWsiLCJoZWFkZXIiOnsidHlwZSI6IlJlZnJlc2giLCJhbGciOiJIUzI1NiJ9LCJleHAiOjE3NTYzMjUwNzB9.br_24UDGcsvZpzHNCySndkrjy0RDDEFzuq-Beq2-HDk")
                .and().body("") // POJO -> Json = SERIALIZATION
                .and().log().all()
                .when().post("/drivers");
        postResponse.then().log().all();
        postResponse.then().statusCode(200);

    }
    @Then("user validates status code {int}")
    public void user_validates_status_code() {

    }
    @Then("user validates response data matches with request data")
    public void user_validates_response_data_matches_with_request_data() {

    }

    @Then("user validates response body error message {string}")
    public void user_validates_response_body_error_message(String errorMessage) {

    }
}
