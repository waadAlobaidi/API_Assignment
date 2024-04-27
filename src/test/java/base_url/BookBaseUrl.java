package base_url;



import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;

public class BookBaseUrl {


    protected RequestSpecification spec;

    @BeforeMethod
    public void setUp(){

        spec = new RequestSpecBuilder()
                .setBaseUri("https://restful-booker.herokuapp.com")
                .build();

    }

}
