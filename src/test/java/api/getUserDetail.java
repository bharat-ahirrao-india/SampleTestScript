package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.config.SSLConfig.sslConfig;

public class getUserDetail {

    @Test
    public void getRequest() {
        RestAssured.config = RestAssured.config().sslConfig(sslConfig().relaxedHTTPSValidation());
        Response response = RestAssured.get("https://reqres.in/api/users?page=2");
        System.out.println("Response : " + response.asString());
        System.out.println("Status Code : " + response.getStatusCode());
        System.out.println("Body : " + response.getBody().asString());
        System.out.println("Header : " + response.getHeader("content-type"));
    }

    @Test
    public void getRequest2() {
        RestAssured.config = RestAssured.config().sslConfig(sslConfig().relaxedHTTPSValidation());
        given().get("https://reqres.in/api/users?page=2")
                .then().statusCode(200);
    }
}
