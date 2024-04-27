package HomeWorks;

import base_url.BookBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class Hm02Mentoring extends BookBaseUrl {

    // Given https://dummy.restapiexample.com/api/v1/employees
// When user send Request via GET Method
// Then Assert that Status Code is "200"
// And Print employee_age greater than 55 to the console. Assert that there are 8.
// And Print the ones with id's greater than 17 to the console and assert that there are 7.
// And Print the ones with salary is less than 100,000 to the console.Assert that
// Doris Wilder is one of them.

    @Test
    public void test02(){
        spec.pathParams("first", "v1", "second", "employees");

        Response response = given(spec).get("{first}/{second}");
        response.prettyPrint();

        response.then().statusCode(200);

        JsonPath jsonPath = response.jsonPath();

        List<Integer> employee_age_list = jsonPath.getList("data.findAll{it.employee_age>55}.employee_age");
        System.out.println("Employee age greater than 55 = " + employee_age_list);
        assertThat(employee_age_list.size(), equalTo(8));

        List<Integer> ids_greater_17 = jsonPath.getList("data.findAll{it.id>17}.id");
        System.out.println("Ids greater than 17 = " + employee_age_list);
        assertEquals(ids_greater_17.size(), 7);

        List<String> salary_less = jsonPath.getList("data.findAll{it.employee_salary<1000000}.employee_name");
        System.out.println("Employee with salary less than 1000000 = " + salary_less);
        assertTrue(salary_less.contains("Doris Wilder"));



    }
}
