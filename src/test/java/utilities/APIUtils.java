package utilities;

import io.restassured.response.Response;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class APIUtils {

    //public static String token = DataLoader.token;
    public static String token = "Access=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJzdHVkZW50QG1pbmR0ZWsiLCJoZWFkZXIiOnsidHlwZSI6IkFjY2VzcyIsImFsZyI6IkhTMjU2In0sImV4cCI6MTc2MTg3MTcxMn0.Ja9iqzGOQI3TkH4og3kDSEHBPCn1tnSxjWcNGGsIR6Q; Refresh=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJzdHVkZW50QG1pbmR0ZWsiLCJoZWFkZXIiOnsidHlwZSI6IlJlZnJlc2giLCJhbGciOiJIUzI1NiJ9LCJleHAiOjE3NjE4NzE3MTJ9.V40a1NiDY90B4VdfFcmrZFvdN2BrCVOro8efHg58d_g";

    public static void getCall(Map<String, Object> queryParams, String endpoint) {

        Response getResponse = given().baseUri(ConfigReader.getProperty("ElarAPIBaseURL"))
                .and().accept("application/json")
                .and().header("Cookie", token)
                .and().queryParams(queryParams)
                .and().log().all()
                .when().get(endpoint);
        getResponse.then().log().all();
        DataLoader.responseData.put("getResponse",getResponse);
    }

    public static void getCall(String endpoint) {
        Response getResponse = given().baseUri(ConfigReader.getProperty("ElarAPIBaseURL"))
                .and().accept("application/json")
                .and().header("Cookie", token)
                .and().log().all()
                .when().get(endpoint);
        getResponse.then().log().all();
        DataLoader.responseData.put("getResponse",getResponse);
    }

    public static void postCall(Object body, String endpoint) {
        Response postResponse = given().baseUri(ConfigReader.getProperty("ElarAPIBaseURL"))
                .and().accept("application/json")
                .and().contentType("application/json")
                .and().cookie(token)
                .and().body(body)
                .and().log().all()
                .when().post(endpoint);
        postResponse.then().log().all();
        DataLoader.responseData.put("postResponse",postResponse);
    }

    public static void putCall(Object body, String endpoint) {
        Response putResponse = given().baseUri(ConfigReader.getProperty("ElarAPIBaseURL"))
                .and().accept("application/json")
                .and().contentType("application/json")
                .and().header("Cookie", token)
                .and().body(body)
                .and().log().all()
                .when().put(endpoint);
        putResponse.then().log().all();
        DataLoader.responseData.put("putResponse",putResponse);
    }

    public static void deleteCall(String endpoint) {
        Response deleteResponse = given().baseUri(ConfigReader.getProperty("ElarAPIBaseURL"))
                .and().log().all()
                .and().header("Cookie", token)
                .when().delete(endpoint);
        deleteResponse.then().log().all();
        DataLoader.responseData.put("deleteResponse",deleteResponse);
    }
}
