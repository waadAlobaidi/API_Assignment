package requests;

import base_url.JsonPlaceHolderBaseUrl;
import base_url.JsonPlaceHolderTestData;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class Assignment08 extends JsonPlaceHolderBaseUrl {
     /*
        Given
            1) https://reqres.in/api/users
            2) {
                "name": "morpheus",
                "job": "leader"
                }
        When
            I send POST Request to the Url
        Then
            Status code is 201
            And response body should be like {
                                                "name": "morpheus",
                                                "job": "leader",
                                                "id": "496",
                                                "createdAt": "2022-10-04T15:18:56.372Z"
                                              }
     */

    @Test
    public void homework08(){

        String url = "https://reqres.in/api/unknown/3";
        Response response = given().get(url);
        response.prettyPrint();
        Map<String, Object> expectedData = new HashMap<>();
        expectedData.put("name", "morpheus");
        expectedData.put("job", "leader");
        response .then()
                .statusCode(201)
                .body("data.name", equalTo("morpheus"))
                .body("data.job", equalTo("leader"))
                .body("data.id", equalTo(496))
                .body("data.createdAt", equalTo( "2022-10-04T15:18:56.372Z"));

    }

    }

