import io.restassured.response.Response;
import org.testng.annotations.Test;
 
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
 
public class PojoTest {
 
    private static final String BASE_URL =
            "https://api.restful-api.dev/objects";
 
    @Test
    public void testSerializationAndDeserialization() {
 
        // STEP 1: Create nested product data
        ProductData data = new ProductData(
                2026,
                85000,
                "Automation Testing"
        );
 
        // STEP 2: Create request POJO
        ProductRequest request = new ProductRequest(
                "QA Automation Laptop",
                data
        );
 
        // STEP 3: SERIALIZATION
        // Rest Assured + Jackson converts the Java object to JSON.
        Response postResponse =
                given()
                    .contentType("application/json")
                    .body(request)
                    .log().body()
                .when()
                    .post(BASE_URL);
 
        // STEP 4: Validate POST response
        postResponse.then().statusCode(200);
 
        // STEP 5: DESERIALIZATION
        // Convert the JSON response into a Java object.
        ProductResponse createdProduct =
                postResponse.as(ProductResponse.class);
 
        // STEP 6: Validate response values
        assertNotNull(
                createdProduct.getId(),
                "Generated ID must not be null"
        );
 
        assertEquals(
                createdProduct.getName(),
                "QA Automation Laptop"
        );
 
        assertEquals(
                createdProduct.getData().getYear(),
                2026
        );
 
        assertEquals(
                createdProduct.getData().getPrice(),
                85000
        );
 
        String id = createdProduct.getId();
 
        System.out.println("Created ID: " + id);
        System.out.println(
                "Created name: " + createdProduct.getName()
        );
        System.out.println(
                "Created price: "
                + createdProduct.getData().getPrice()
        );
 
        // STEP 7: GET the created object
        Response getResponse =
                given()
                .when()
                    .get(BASE_URL + "/" + id);
 
        getResponse.then().statusCode(200);
 
        // STEP 8: Deserialize the GET response
        ProductResponse fetchedProduct =
                getResponse.as(ProductResponse.class);
 
        // STEP 9: Verify retrieved data
        assertEquals(fetchedProduct.getId(), id);
 
        assertEquals(
                fetchedProduct.getName(),
                "QA Automation Laptop"
        );
 
        assertEquals(
                fetchedProduct.getData().getPrice(),
                85000
        );
 
        System.out.println("GET verification passed");
        System.out.println(
                "Retrieved product: " + fetchedProduct.getName()
        );
    }
}
