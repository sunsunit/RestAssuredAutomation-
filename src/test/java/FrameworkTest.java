import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
 
import static org.hamcrest.Matchers.greaterThan;
 
public class FrameworkTest {
 
    private static final Logger log =
            LogManager.getLogger(FrameworkTest.class);
 
    @Test
    public void verifyObjectsEndpoint() {
 
        log.info("Starting Objects API test");
 
        ApiClient client = new ApiClient();
 
        log.info("Sending GET request to /objects");
 
        client.get("/objects")
                .then()
                .log().all()
                .statusCode(200)
                .body("size()", greaterThan(0));
 
        log.info("Objects API test passed");
    }
}

