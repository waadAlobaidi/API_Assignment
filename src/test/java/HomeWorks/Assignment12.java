package HomeWorks;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.JsonPlaceHolderPojo;
import test_data.BookerBaseUrl;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class Assignment12 extends BookerBaseUrl {

   /* Write an automation test that will create, read, update, delete a 'pet' using the "https://petstore.swagger.io/" document
(All actions must be done on same pet)
            (Use Pojo)

    */

    String url = ("https://petstore.swagger.io/v2/pet");

       @Test
       public void HW12(){
           JsonPlaceHolderPojo pet = new JsonPlaceHolderPojo(3, "Fuly", "available");

           Response response = given()
                   .contentType(ContentType.JSON)
                   .body(pet)
                   .when()
                   .post(url);

           assertEquals(response.getStatusCode(), 200);
       }

       @Test(priority = 1)
       public void CreatePets() {
           Response response = RestAssured.get(url + "/3");

           assertEquals(response.getStatusCode(), 200);
           JsonPlaceHolderPojo pet = response.getBody().as(JsonPlaceHolderPojo.class);
           assertEquals(pet.getName(), "Fuly");
       }

       @Test(priority = 2)
       public void UpdatePets() {
           JsonPlaceHolderPojo pet = new JsonPlaceHolderPojo(3, "Fuly", "Not available");

           Response response = given()
                   .contentType(ContentType.JSON)
                   .body(pet)
                   .when()
                   .put(url);

           assertEquals(response.getStatusCode(), 200);
       }

       @Test(priority = 3)
       public void DeletePets() {
           Response response = RestAssured.delete(url + "/3");

           assertEquals(response.getStatusCode(), 200);
       }

   }