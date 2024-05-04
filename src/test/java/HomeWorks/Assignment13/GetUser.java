package HomeWorks.Assignment13;

import base_url.UserBaseUrl;
import pojos.UserPojo;
import Utilities.ObjectMapperUtils;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class GetUser  extends UserBaseUrl {
    @Test
    public void getUserTest() {

        //set the url
        spec.pathParams("first", "user", "second", "walaH");

        //set the expected data
        String strJson = """
                {
                  "id": 111,
                  "username": "walaH",
                  "firstName": "Wala",
                  "lastName": "Herbi",
                  "email": "wala@gmail.com",
                  "password": "123456",
                  "phone": "05999999",
                  "userStatus": 1
                }
                """;
        UserPojo expectedData = ObjectMapperUtils.convertJsonToJava(strJson, UserPojo.class);
        System.out.println("expectedData = " + expectedData);

        //send the request and get the response
        Response response = given(spec).body(expectedData).get("{first}/{second}");
        response.prettyPrint();

        // do assertion
        UserPojo actualData = ObjectMapperUtils.convertJsonToJava(response.asString(), UserPojo.class);
        System.out.println("actualData = " + actualData);
        assertEquals(response.statusCode(), 200);
        assertEquals(expectedData.getId(), actualData.getId());
        assertEquals(expectedData.getUsername(), actualData.getUsername());
        assertEquals(expectedData.getFirstName(), actualData.getFirstName());
        assertEquals(expectedData.getLastName(), actualData.getLastName());
    }
}