package HomeWorks.Assignment13;
import base_url.UserBaseUrl;
import pojos.UserPojo;
import Utilities.ObjectMapperUtils;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;


public class UpdateUser extends UserBaseUrl {

    @Test
    void updateUserTest()  {
        spec.pathParams("first", "user", "second", "walaH");
        //Set the expected data
        String strJson = """
                {
                  "id": 111,
                  "username": "walaH",
                  "firstName": "Wala",
                  "lastName": "Herbi",
                  "email": "wala11@gmail.com",
                  "password": "123456",
                  "phone": "051111111",
                  "userStatus": 1
                }
                """;

        UserPojo expectedData = ObjectMapperUtils.convertJsonToJava(strJson, UserPojo.class);
        System.out.println("expectedData = " + expectedData);

        //Send the request and get the response
        Response response = given(spec).body(expectedData).put("{first}/{second}");


        //Do assertion
        response.then().statusCode(200);
        response.prettyPrint();
    }
}

