package HomeWorks;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Assignment11 {

    /*
    Given
        https://automationexercise.com/api/productsList
    When
        User sends a GET request
    Then
        Assert that the number of "Women" user type is 12

    Note: Print using JsonPath: response.jsonPath().prettyPrint();

*/
    @Test
    public void test011(){

        Response response = RestAssured.get("https://automationexercise.com/api/productsList");

        JsonPath jsonpath = response.jsonPath();
        jsonpath.prettyPrint();

        assertEquals(response.statusCode(), 200);

        int womenCount = response.jsonPath().getList("products.findAll { it.category.usertype.usertype == 'Women' }").size();
        assertEquals(womenCount, 12);
    }
}
