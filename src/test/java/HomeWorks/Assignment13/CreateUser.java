package HomeWorks.Assignment13;
import base_url.UserBaseUrl;
import pojos.UserPojo;
import Utilities.ObjectMapperUtils;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateUser extends UserBaseUrl {
    @Test
    public void createUserTest()  {

        //set the url
        spec.pathParams("first", "user");

        // set the expected data
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
        Response response = given(spec).body(expectedData).post("{first}");
        response.prettyPrint();

        // do assertion
        response.then().statusCode(200);
    }
}