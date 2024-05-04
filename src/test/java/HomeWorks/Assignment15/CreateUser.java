package HomeWorks.Assignment15;
import pojos.ContactListAddUserPojo;
import base_url.ContactUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static Utilities.ObjectMapperUtils.convertJsonToJava;

public class CreateUser extends ContactUrl{
    @Test
    public void CreateUserTest() {

        //set the url
        spec.pathParams("1","users");

        // set the expected data
        String strJson = """
            {
                "firstName": "waad",
                "lastName": "herb",
                "email": "waad55@gmail.com",
                "password": "123456009"
            }
            """;

        ContactListAddUserPojo expectedData = convertJsonToJava(strJson, ContactListAddUserPojo.class);

        //send the request and get the response
        Response response = given(spec).body(expectedData).post("{1}");
        response.prettyPrint();

        // do assertion
        response.then().statusCode(201);
    }
}
