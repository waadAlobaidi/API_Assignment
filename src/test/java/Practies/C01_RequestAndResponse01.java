package Practies;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.*;
import static org.testng.Assert.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class C01_RequestAndResponse01 {
    /*
    Given
        https://restful-booker.herokuapp.com/booking
    When
        User sends a GET Request to the url
    Then
        HTTP Status Code should be 200
    And
        Content Type should be JSON
    And
        Status Line should be HTTP/1.1 200 OK
    And
        Print Connection and Date headers on console
    And
        Print all headers on console

*/

    @Test
    public void test01(){
        Response response = RestAssured.get("https://restful-booker.herokuapp.com/booking");
        response.prettyPrint();

        int statusCode = response.statusCode();
        System.out.println("Status Code is: " +statusCode);

        String contentType = response.contentType();
        System.out.println("Content Type is: " +contentType);

        String statusLine = response.statusLine();
        System.out.println("Status Line: " +statusLine);

        String connection = response.header("Connection");
        System.out.println("Connection : " +connection);

        String date = response.header("Date");
        System.out.println("Date: " +date);

        Headers headers = response.headers();
        System.out.println("Headers: " +headers);
    }

    @Test
    public void test02(){
        Response response = RestAssured.get("https://restful-booker.herokuapp.com/booking");
        response.prettyPrint();

        //response.then().statusCode(200);
//        response.then().contentType("application/json");
//        response.then().statusLine("HTTP/1.1 200 OK");
//        response.then().header("Connection","keep-alive");

        int statuscde = response.statusCode();
        assertEquals(statuscde, 404);
    }





    @Test
    public void test04(){
        String url = "https://jsonplaceholder.typicode.com/todos/23";
        Response response = given().get("url");
        response.prettyPrint();

        //4. Do Assertion
//        HTTP Status Code should be 200
//        Response format should be “application/json”
//        “title” is “et itaque necessitatibus maxime molestiae qui quas velit”
//        “completed” is false
//        “userId” is 2

        response.then().statusCode(200)
                .contentType("application/json")
                .body("title", equalTo("et itaque necessitatibus maxime molestiae qui quas velit"))
                .body("completed", equalTo(false))
                .body("userId", equalTo(2));


    }
}
