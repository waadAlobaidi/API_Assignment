package HomeWorks;

import base_url.BookBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Hm01Mentoring extends BookBaseUrl {
//    / Base URL should be used as Spec
//// Given https://gorest.co.in/public/v2/todos/47900
//// When user send Request via GET Method
//// Then Assert that Status Code is "200"
//// And Assert that Content Type is "application/json"
//// And Assert that Response Body is as follows:
//    {
//        "id": 47900,
//            "user_id": 6861183,
//            "title": "Et minus libero aegrotatio teres quia.",
//            "due_on": "2024-04-25T00:00:00.000+05:30",
//            "status": "pending"
//    }

    @Test
    public void test01(){

        spec.pathParams("first", "todos", "second", "47900");


        Response response = given(spec).get("{first}/{second}");
        response.prettyPrint();

        response.then().statusCode(200).contentType("application/json")
                .body("id", equalTo(47900),
                        "user_id", equalTo(6861183),
                        "title", equalTo("Et minus libero aegrotatio teres quia."),
                        "due_on", equalTo("2024-04-25T00:00:00.000+05:30"),
                        "status", equalTo("pending"));

    }
}
