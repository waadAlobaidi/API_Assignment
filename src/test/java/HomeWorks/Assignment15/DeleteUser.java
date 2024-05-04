package HomeWorks.Assignment15;

import base_url.ContactUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class DeleteUser extends ContactUrl {


    @Test
    public void DeleteUserTest(){

        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NjM2OGJlYzBhOTM3NjAwMTNmMGQxZmQiLCJpYXQiOjE3MTQ4NTA3OTZ9.IMjpsGf2nziT9P32ttiTMXpj4TUXYuQ1HlQHDr3jLjk";

        //set the url
        spec.pathParams("1","users","2","me");

        //send the request and get the response
        Response response = given(spec).header("Authorization", "Bearer " + token).delete("{1}/{2}");

        // do assertion
        response.then().statusCode(200);
    }
}
