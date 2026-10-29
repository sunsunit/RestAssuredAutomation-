import org.testng.annotations.Test;
 
import static io.restassured.RestAssured.given;
 
public class AdvancedApiTest {
 
    private static final String BASE_URL =
            "https://api.restful-api.dev";
 
    @Test
    public void getObjectUsingPathParameter() {
 
        given()
            .pathParam("id", "7")
        .when()
            .get(BASE_URL + "/objects/{id}")
        .then()
            .statusCode(200)
            .log().body();
    
    }
    @Test
public void getObjectsUsingQueryParameter() {
 
    given()
        .queryParam("id", "7")
    .when()
        .get("https://api.restful-api.dev/objects")
    .then()
        .log().all();
}
    @Test
public void getUsingReusableSpecification() {
 
    given()
        .spec(SpecBuilder.getRequestSpec())
    .when()
        .get("/objects")
    .then()
        .statusCode(200)
        .log().body();
}
@Test

public void extractObjectId() {
 
    String id =

        given()

        .when()

            .get("https://api.restful-api.dev/objects/7")

        .then()

            .statusCode(200)

            .extract()

            .path("id");
 
    System.out.println("Extracted ID: " + id);
 
    given()

        .pathParam("id", id)

    .when()

        .get("https://api.restful-api.dev/objects/{id}")

    .then()

        .statusCode(200);

}
 
}
