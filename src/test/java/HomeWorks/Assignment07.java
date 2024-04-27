package HomeWorks;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertEquals;

public class Assignment07 {
     /*
       Given
              https://reqres.in/api/unknown/
       When
            I send GET Request to the URL
       Then

            1)Status code is 200
            2)Print all pantone_values
            3)Print all ids greater than 3 on the console
              Assert that there are 3 ids greater than 3
            4)Print all names whose ids are less than 3 on the console
              Assert that the number of names whose ids are less than 3 is 2
    */

    @Test
    public void testAssignment07() {
        Response response = given().get("https://reqres.in/api/unknown/");
        response.prettyPrint();

        response
                .then().statusCode(200);

        JsonPath jsonPath = response.jsonPath();
        List<Object> pantone_values_list = jsonPath.getList("data.pantone_value");
        System.out.println("pantoneValuesList = " + pantone_values_list);

        List<Integer> ids = jsonPath.getList("data.findAll{it.id>3}.id");
        System.out.println("Ids greater than 3 = " + ids);

        int idsGreater3 = response.jsonPath().getInt("data.findAll{it.id>3}.size()");
        assertThat(idsGreater3, equalTo(3));

        List<String> namesList = jsonPath.getList("data.findAll{it.id<3}.name");
        System.out.println("name whose ids less than 3 = " + namesList);
        assertEquals(namesList.size(), 2);
    }
}