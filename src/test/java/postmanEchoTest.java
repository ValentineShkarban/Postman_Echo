import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class postmanEchoTest {

    @Test
    public void bodyRequest() {
        String text = "Hello World!";
        given()
                .baseUri("https://postman-echo.com")
                .contentType("text/plain; charset=UTF-8")
                .body(text)
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("data", Matchers.equalTo(text))
        ;
    }
}
