package stepDefs.RestGetStepdef;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.net.URI;
import java.net.URISyntaxException;

public class RestGetStepdef {

    private final String BaseURI = "https://reqres.in/api/users?page=2";
    private Response response;
    private Scenario scenario;

    @Before
    public void before (Scenario scenario){
        this.scenario = scenario;
    }

    @Given("Get call to {string}")
    public void getCallTo(String url)throws URISyntaxException {
        RestAssured.baseURI = BaseURI;
        RequestSpecification requestSpecification = RestAssured.given();
        response = requestSpecification.when().get(new URI(url));
    }

    @Then("Response is {string}")
    public void responseIs(String statusCode) {
        int actualResponseCode = response.then().extract().statusCode();
        Assert.assertEquals(statusCode,actualResponseCode+ " ");

    }
}
