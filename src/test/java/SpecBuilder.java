// import io.restassured.builder.RequestSpecBuilder;
// import io.restassured.specification.RequestSpecification;
 
// public class SpecBuilder {
 
//     public static RequestSpecification getRequestSpec() {
 
//         return new RequestSpecBuilder()
//                 .setBaseUri("https://api.restful-api.dev")
//                 .setContentType("application/json")
//                 .build();
//     }
// }

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
 
public class SpecBuilder {
 
    public static RequestSpecification getRequestSpec() {
 
        return new RequestSpecBuilder()
                .setBaseUri(Config.getBaseUri())
                .setContentType("application/json")
                .build();
    }
}
