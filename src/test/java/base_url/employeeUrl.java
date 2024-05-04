package base_url;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;

public class employeeUrl {
    protected RequestSpecification spec;

    @BeforeMethod
    public void setSpec() {

        spec = new RequestSpecBuilder()
                .setBaseUri("https://dummy.restapiexample.com/api/v1")
                .setContentType(ContentType.JSON)
                .build();

    }


}

