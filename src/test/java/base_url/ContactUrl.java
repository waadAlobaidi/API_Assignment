package base_url;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;

public class ContactUrl {
    protected RequestSpecification spec ;

    @BeforeMethod //Runs before each @Test
    public void setUpBaseURL() {
        spec = new RequestSpecBuilder()
                .setBaseUri("https://thinking-tester-contact-list.herokuapp.com")
                .setContentType(ContentType.JSON)
                .build();
    }
}
