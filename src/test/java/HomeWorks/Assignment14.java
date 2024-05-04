package HomeWorks;
import base_url.employeeUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import java.util.List;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import io.restassured.path.json.JsonPath;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Assignment14 extends employeeUrl {
    /*
    Given
        https://dummy.restapiexample.com/api/v1/employees
    When
        User sends Get Request to the Url
    Then
        Status code is 200
    And
        There are 24 employees
    And
        "Tiger Nixon" and "Garrett Winters" are among the employees
    And
        The greatest age is 66
    And
        The name of the lowest age is "Tatyana Fitzpatrick"
    And
        Total salary of all employees is 6,644,770
 */
    @Test
    void hw14(){
        //Set the url
        spec.pathParams("first", "employees");

        //Send the request and get the response
        Response response = given(spec).get("{first}");
        response.prettyPrint();
        JsonPath jsonPath = response.jsonPath();

        //Do Assertion
        response
                .then()
                .statusCode(200);

//     Assert There are 24 employees
        int numberOfEmployees = jsonPath.getList("data.id").size();
        System.out.println("The number of all employee: " +numberOfEmployees);
        assert numberOfEmployees == 24;


//     Assert "Tiger Nixon" and "Garrett Winters" are among the employees
        List<String> employeesNamesList = jsonPath.getList("data.findAll{it}.employee_name");
        System.out.println("Employee Names: " + employeesNamesList);
        assertTrue(employeesNamesList.contains("Tiger Nixon"));
        assertTrue(employeesNamesList.contains("Garrett Winters"));

//      Assert The greatest age is 66
        int greatestEmployeeAge = jsonPath.getInt("data.max{it.employee_age}.employee_age");
        System.out.println("The greatest Employee Name is: "+ greatestEmployeeAge);
        assertEquals(greatestEmployeeAge, 66);

//       Assert The name of the lowest age is "Tatyana Fitzpatrick"
        String lowestAge = jsonPath.getString("data.find {it.employee_age == 19 }.employee_name");
        System.out.println("The lowest age: "+lowestAge);
        assertEquals(lowestAge, "Tatyana Fitzpatrick");

//       Assert Total salary of all employees is 6,644,770
        int totalSalary = jsonPath.getInt("data.employee_salary.sum()");
        System.out.println("The total salary for all employees : " + totalSalary);
        assertThat(totalSalary, equalTo(6644770));


    }

}

