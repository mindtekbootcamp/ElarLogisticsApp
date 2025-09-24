package utilities;

import io.restassured.response.Response;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class APIUtils {

    public static String token = ConfigReader.getProperty("ElarAPIToken");

    public static Response getCall(Map<String, Object> queryParams, String endpoint){

        Response getResponse = given().baseUri(ConfigReader.getProperty("ElarAPIBaseURL"))
                .and().accept("application/json")
                .and().header("Cookie", token)
                .and().queryParams(queryParams)
                .and().log().all()
                .when().get(endpoint);
        getResponse.then().log().all();
        return getResponse;
    }

    public static Response getCall(String endpoint){
        Response getResponse = given().baseUri(ConfigReader.getProperty("ElarAPIBaseURL"))
                .and().accept("application/json")
                .and().header("Cookie", token)
                .and().log().all()
                .when().get(endpoint);
        getResponse.then().log().all();
        return getResponse;
    }

    public static Response postCall(Object body, String endpoint){
        Response postResponse = given().baseUri(ConfigReader.getProperty("ElarAPIBaseURL"))
                .and().accept("application/json")
                .and().contentType("application/json")
                .and().header("Cookie", token)
                .and().body(body)
                .and().log().all()
                .when().post(endpoint);
        postResponse.then().log().all();
        return postResponse;
    }

    public static Response putCall(Object body, String endpoint){
        Response putResponse = given().baseUri(ConfigReader.getProperty("ElarAPIBaseURL"))
                .and().accept("application/json")
                .and().contentType("application/json")
                .and().header("Cookie", token)
                .and().body(body)
                .and().log().all()
                .when().put(endpoint);
        putResponse.then().log().all();
        return putResponse;
    }

    public static Response deleteCall(String endpoint){
        Response deleteResponse = given().baseUri("ElarAPIBaseURL")
                .and().log().all()
                .and().header("Cookie", token)
                .when().delete(endpoint);
        deleteResponse.then().log().all();
        return deleteResponse;
    }
}
