package HomeWorks.Assignment16;
import base_url.ContactUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class GetContact extends ContactUrl{

    @Test
    public void GetContactTest(){

        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NjM0ZTZiZDA2YzIwOTAwMTNjMjRkYTEiLCJpYXQiOjE3MTQ3NDM1MTZ9.jih80DoyGHMqmCMNRUX1JzW0lKI5O-fn6rzhB1oebLg";

        //set the url
        spec.pathParams("1","contacts");

        //send the request and get the response
        Response response = given(spec).header("Authorization", "Bearer " + token).get("{1}");

        // do assertion
        response.then().statusCode(200);
        response.prettyPrint();

}
}
