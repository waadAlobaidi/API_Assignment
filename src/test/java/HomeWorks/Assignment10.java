package HomeWorks;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import test_data.BookerBaseUrl;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertTrue;

public class Assignment10 extends BookerBaseUrl {


/*   Using the https://petstore.swagger.io/ document, write an automation test that finds
the number of "pets" with the status "available" and asserts that there are more than 100.
 */

    @Test
    public void autoTest(){

        spec.pathParams("first", "pet","second","findByStatus")
                .queryParams("status","available");

        Response response = given(spec).get("{first}/{second}");
        response
                .then()
                .statusCode(200);
        response.prettyPrint();

        JsonPath jsonpath = response.jsonPath();
        List<String> available = jsonpath.getList("name");
        System.out.println("The available pets:  " + available.size());
        assertTrue(available.size() > 100);


    }
}
