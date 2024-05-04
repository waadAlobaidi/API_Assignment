package HomeWorks.Assignment15;

import Utilities.ObjectMapperUtils;
import base_url.ContactUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.ContactListAddUserPojo;
import pojos.UserPojo;

import static Utilities.ObjectMapperUtils.convertJsonToJava;
import static io.restassured.RestAssured.given;

public class CreateContact extends ContactUrl {
    public static String authToken;

    @Test
    public void createContactTest(){
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NjM0ZTZiZDA2YzIwOTAwMTNjMjRkYTEiLCJpYXQiOjE3MTQ3NDM1MTZ9.jih80DoyGHMqmCMNRUX1JzW0lKI5O-fn6rzhB1oebLg";

        spec.pathParams("1","contacts");

        String strJson = """
                {
                    "firstName": "John",
                    "lastName": "Doe",
                    "birthdate": "1970-01-01",
                    "email": "jdoe@fake.com",
                    "phone": "8005555555",
                    "street1": "1 Main St.",
                    "street2": "Apartment A",
                    "city": "Anytown",
                    "stateProvince": "KS",
                    "postalCode": "12345",
                    "country": "USA"
                }
                """;

        ContactListAddUserPojo expectedData = convertJsonToJava(strJson, ContactListAddUserPojo.class);

        //send the request and get the response
        Response response = given(spec).header("Authorization", "Bearer " + token).body(expectedData).post("{1}");
        response.prettyPrint();

    }
}
