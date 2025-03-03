package Api.example;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TestFirstExample {
    @Test
    public void testSignUp(){
        String payload = "{\"username\" = \"jjajsj\",\"password\"=\"skksks\", \"firstname\"=\"aaaa\",\"lastname\"= \"jajsj\"}";
        RestAssured.baseURI = "http://127.0.0.1:5001";
        given()
                .header ("Content-Type", "application/json")
                .body (payload)
                .when()
                .post("/sigup")
                .then()
                .statusCode(201)
                .contentType(ContentType.JSON)
                .body("message", equalTo("User created successfully"))
                .body("username",equalTo("jjajsj"));


    }
}
