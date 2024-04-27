package HomeWorks;

import base_url.BookBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class Assignment06 extends BookBaseUrl {
    /*
        Given
          https://reqres.in/api/unknown/3
        When
            User send a GET request to the URL
        Then
            HTTP Status Code should be 200
        And
            Response content type is "application/json; charset=utf-8"
        And
            Response body should be like;(Soft Assertion)
        {
        "data": {
            "id": 3,
            "name": "true red",
            "year": 2002,
            "color": "#BF1932",
            "pantone_value": "19-1664"
        },
        "support": {
            "url": "https://reqres.in/#support-heading",
            "text": "To keep ReqRes free, contributions towards server costs are appreciated!"
        }
}
      */

    @Test
    public void assignment006(){
        String url = "https://reqres.in/api/unknown/3";
        Response response = given().get(url);
        response.prettyPrint();

        //Do assertion
        response
                .then()
                .statusCode(200)
                .contentType("application/json; charset=utf-8");

        JsonPath jsonPath = response.jsonPath();

        //Retrieve the desired data by using JsonPath object
        SoftAssert softAssert = new SoftAssert();


        int id = jsonPath.getInt("data.id");
        softAssert.assertEquals(id, 3);
        String name = jsonPath.get("data.name");
        softAssert.assertEquals(name, "true red");
        int year = jsonPath.get("data.year");
        softAssert.assertEquals(year, "2002");
        String color = jsonPath.get("data.color");
        softAssert.assertEquals(color, "#BF1932");
        String pantone_value = jsonPath.get("data.pantone_value");
        softAssert.assertEquals(pantone_value, "19-1664");
        String Url = jsonPath.get("support.url");
        softAssert.assertEquals(Url, "https://reqres.in/#support-heading");
        String text = jsonPath.get("support.text");
        softAssert.assertEquals(text, "To keep ReqRes free, contributions towards server costs are appreciated!");


    }
}
