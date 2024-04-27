package HomeWorks;

import base_url.BookBaseUrl;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import test_data.BookerBaseUrl;

import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class Assignment09 extends BookerBaseUrl {
    /*
Write an automation test that will create a 'user' using the "https://petstore.swagger.io/" document
*/

    @Test
            public void createUser(){

        Map<String, Object> payloadRequest = new HashMap<>();
        payloadRequest.put("id", 001);
        payloadRequest.put("username", "waadM");
        payloadRequest.put("firstName", "waad");
        payloadRequest.put("lastName", "alobaidi");
        payloadRequest.put("email", "waad@gmail.com");
        payloadRequest.put("password", "123456");
        payloadRequest.put("phone", "056666666");
        payloadRequest.put("userStatus", 0);



        // Send POST request with user data
        RestAssured.given()
                .contentType(ContentType.JSON)
                .body(payloadRequest)
                .post("/users");

    }

}
