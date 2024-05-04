package HomeWorks.Assignment13;
import base_url.UserBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DeleteUser extends UserBaseUrl{

    @Test
    void deleteUserTest() {
        //Set the url
        spec.pathParam("first", "user").pathParam("second", "walaH");

        // Send the request and get the response
        Response response = given(spec).delete("/{first}/{second}");
        response.prettyPrint();

        // do assertion
        assertEquals(response.getStatusCode(), 200);
        assertTrue(response.asString().contains("walaH"));
    }
}

