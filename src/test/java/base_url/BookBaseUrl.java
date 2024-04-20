package base_url;


import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;

public class BookBaseUrl {

    // We avoid repetitive tasks when sending requests with the RequestSpecification object.
    // For example: repetitive tasks such as base URL and headers.

    protected RequestSpecification spec;

    @BeforeMethod //Runs before each @Test
    public void setUp(){

        spec = new RequestSpecBuilder()
                .setBaseUri("https://reqres.in/api")
                .build();

    }



}
