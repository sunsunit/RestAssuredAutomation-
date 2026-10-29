

import io.restassured.response.Response;

import org.testng.annotations.Test;
 
import static io.restassured.RestAssured.given;

import static org.hamcrest.Matchers.equalTo;

import static org.hamcrest.Matchers.greaterThan;

import static org.testng.Assert.assertEquals;

import static org.testng.Assert.assertNotNull;
 
public class CRUDTest {
 
    private static final String BASE_URL =

            "https://api.restful-api.dev/objects";
 
    // TEST 1: Smoke test - verify the API is responding

    @Test

    public void smokeTest() {
 
        given()

        .when()

            .get(BASE_URL)

        .then()

            .statusCode(200)

            .body("size()", greaterThan(0));
 
        System.out.println("Smoke test passed");

    }
 
    // TEST 2: Complete CRUD workflow

    @Test

    public void testCompleteCRUD() {
 
        // 1. POST - Create object

        String createBody = """

            {

                "name": "QA Automation Laptop",

                "data": {

                    "year": 2026,

                    "price": 85000,

                    "type": "Automation Testing"

                }

            }

            """;
 
        Response postResponse =

                given()

                    .contentType("application/json")

                    .body(createBody)

                .when()

                    .post(BASE_URL);
 
        postResponse.then().statusCode(200);
 
        String id = postResponse.jsonPath().getString("id");
 
        assertNotNull(id, "Generated ID should not be null");
 
        postResponse.then()

                .body("name", equalTo("QA Automation Laptop"));
 
        System.out.println("Created ID: " + id);
 
        // 2. GET - Verify created object

        given()

        .when()

            .get(BASE_URL + "/" + id)

        .then()

            .statusCode(200)

            .body("id", equalTo(id))

            .body("name", equalTo("QA Automation Laptop"))

            .body("data.year", equalTo(2026))

            .body("data.price", equalTo(85000));
 
        System.out.println("GET verification passed");
 
        // 3. PUT - Update object

        String updateBody = """

            {

                "name": "Updated QA Automation Laptop",

                "data": {

                    "year": 2026,

                    "price": 90000,

                    "type": "Updated Automation Testing"

                }

            }

            """;
 
        Response putResponse =

                given()

                    .contentType("application/json")

                    .body(updateBody)

                .when()

                    .put(BASE_URL + "/" + id);
 
        putResponse.then().statusCode(200);
 
        System.out.println("PUT update passed");
 
        // 4. GET - Verify updated values

        given()

        .when()

            .get(BASE_URL + "/" + id)

        .then()

            .statusCode(200)

            .body("name", equalTo("Updated QA Automation Laptop"))

            .body("data.price", equalTo(90000));
 
        System.out.println("Updated values verified");
 
        // 5. DELETE - Delete object

        Response deleteResponse =

                given()

                .when()

                    .delete(BASE_URL + "/" + id);
 
        deleteResponse.then().statusCode(200);
 
        System.out.println("DELETE status: "

                + deleteResponse.statusCode());
 
        // 6. GET - Verify deletion

        Response getAfterDelete =

                given()

                .when()

                    .get(BASE_URL + "/" + id);
 
        assertEquals(

                getAfterDelete.statusCode(),

                404,

                "Expected deleted object to return 404"

        );
 
        System.out.println("Deletion verification passed");

    }

}

 