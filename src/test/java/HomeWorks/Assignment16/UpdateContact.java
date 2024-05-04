package HomeWorks.Assignment16;

import base_url.ContactUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.ContactListAddContactPojo;
import pojos.ContactListAddUserPojo;

import static Utilities.ObjectMapperUtils.convertJsonToJava;
import static io.restassured.RestAssured.given;

public class UpdateContact extends ContactUrl {
    @Test
    public void UpdateUserTest() {

        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NjM0ZTZiZDA2YzIwOTAwMTNjMjRkYTEiLCJpYXQiOjE3MTQ3NDM1MTZ9.jih80DoyGHMqmCMNRUX1JzW0lKI5O-fn6rzhB1oebLg";

        //set the url
        spec.pathParams("1", "contacts");

        // set the expected data
        String strJson = """
                {
                    "firstName": "Anna",
                    "lastName": "Miller",
                    "birthdate": "1992-02-02",
                    "email": "amiller@fake.com",
                    "phone": "8005554242",
                    "street1": "13 School St.",
                    "street2": "Apt. 5",
                    "city": "Washington",
                    "stateProvince": "QC",
                    "postalCode": "A1A1A1",
                    "country": "Canada"
                }
                            """;

        ContactListAddContactPojo expectedData = convertJsonToJava(strJson, ContactListAddContactPojo.class);

        //send the request and get the response
        Response response = given(spec).header("Authorization", "Bearer " + token).body(expectedData).put("{1}");

        // do assertion
        response.then().statusCode(200);
        response.prettyPrint();
    }
}
