package requests;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.AssertJUnit.assertEquals;

public class Assignmenr04 {
    /*
     Given
         https://reqres.in/api/users/2
     When
         User send GET Request to the URL
     Then
         HTTP Status Code should be 200
     And
         Response format should be "application/json"
     And
         "email" is "janet.weaver@reqres.in",
     And
         "first_name" is "Janet"
     And
         "last_name" is "Weaver"
     And
         "text" is "To keep ReqRes free, contributions towards server costs are appreciated!"
  */

    @Test
    public void homeWork04(){

//        1. Set the URL
//        https://reqres.in/api/users/2
        String url = "https://reqres.in/api/users/2";
//        2. Set the expected data
//        3. Send the request and get the response
        Response response = given().get(url);
        response.prettyPrint();

//        4. Do Assertion
        response.then()
                .statusCode(200)
                .contentType("application/json")
                .body("data.email", equalTo("janet.weaver@reqres.in"),"data.first_name", equalTo("Janet")
                ,"data.last_name", equalTo("Weaver")
                ,"support.text", equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"));
    }
}
