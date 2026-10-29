import io.restassured.response.Response;
 
import static io.restassured.RestAssured.given;
 
public class ApiClient {
 
    public Response get(String endpoint) {
        return given()
                .spec(SpecBuilder.getRequestSpec())
                .when()
                .get(endpoint);
    }
 
    public Response post(String endpoint, Object requestBody) {
        return given()
                .spec(SpecBuilder.getRequestSpec())
                .body(requestBody)
                .when()
                .post(endpoint);
    }
 
    public Response put(String endpoint, Object requestBody) {
        return given()
                .spec(SpecBuilder.getRequestSpec())
                .body(requestBody)
                .when()
                .put(endpoint);
    }
 
    public Response delete(String endpoint) {
        return given()
                .spec(SpecBuilder.getRequestSpec())
                .when()
                .delete(endpoint);
    }
}
