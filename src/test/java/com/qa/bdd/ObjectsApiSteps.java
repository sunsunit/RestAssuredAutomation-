package com.qa.bdd;
 
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
 
import io.restassured.response.Response;
import io.restassured.RestAssured;
 
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
 
public class ObjectsApiSteps {
 
    private Response response;
 
    private final String baseUrl =
            "https://api.restful-api.dev/objects";
 
    @Given("the objects API is available")
    public void objectsApiIsAvailable() {
        response = null;
        System.out.println("Objects API test started");
    }
 
    @When("I request the list of objects")
    public void requestListOfObjects() {
        response = RestAssured
                .given()
                .when()
                .get(baseUrl);
 
        System.out.println(
                "Response status: " + response.statusCode()
        );
    }
 
    @Then("the response status should be {int}")
    public void verifyResponseStatus(int expectedStatus) {
        assertEquals(
                response.statusCode(),
                expectedStatus
        );
    }
 
    @Then("the response should contain objects")
    public void verifyResponseContainsObjects() {
        assertTrue(
                response.jsonPath().getList("$").size() > 0,
                "Response should contain at least one object"
        );
    }
}
