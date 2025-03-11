package Api.example;

import Gson.loginGson;
import com.google.gson.Gson;
import groovyjarjarantlr4.runtime.Token;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Login {
    public static String token = "";
    @Test
    public void lgionSuccess() {
        loginGson lggson = new loginGson();
        lggson.setUsername("88060KTV");
        lggson.setPassword("Abcd@54321");
        lggson.setDeviceId("959B7B6E-4281-4CBF-99ED-54ECAA4C61D5");
        lggson.setClientPublicKey("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKC" +
                "AQEA0L8aOXk\\/wL9InjIb2QQUHHDreXL3aJpQucsE1PMczj4RoKGuEmc" +
                "xGIopTo6gHc\\/K9XN7NxuK9o7RKnxwqRts9ILaXr8JEzHcnVmuA2f\\/Ld3uoYO+Tn86" +
                "u9mJVHhEQpqqoMKhsMUj9EBXe1eY64c0W8Ndpc5LsfFYng\\/mvi\\/hICKqbbFUu7TP4" +
                "8qO9rzFlZjmqHgcyhiOIZFAqGEHBMr++pmBmIdQa1z9u3sqV8nKB47GvCP7wfes7D7RLW8DxDGrZ1IXqbhW5Qo" +
                "joVw4c2gfHsna3hzeXwGaX\\/tF\\/CI8c8PRU5rieTz\\/Vf6jqiGbvDsFsWxOv2ZUbOeQlLao3sNikQIDAQAB");
        Gson gson = new Gson();
        RequestSpecification request = given()
                .baseUri("https://bidv.net:9303/bidvorg/service/open-banking/ibank2-sit")
                .contentType("application/json")
                .accept("application/json")
                .header ("X-Forwarded-For", "10.21.101.126")
                .header ("Channel", "IBANK2")
                .header ("Accept-Language", "vi-vn")
                .header ("X-API-Interaction-ID", "128937612989")
                .header ("X-Client-ID", "635bdf50465dce92380c15b9c19d8c51")
                .header ("I-Mobile", "True")
                .header ("I-Client-ID", "APP")
                .header ("I-Device-ID", "027E15E4-AD4B-4612-84A6-6711D241226B")
                .header ("I-Version", "1.0.0")
                .header ("I-Encrypted", "false")
                .header ("I-Os", "Android")
                .header ("I-Os-Version", "17.1.1")
                .header ("I-Device-Model", "MD12343")
                .header ("Timestamp", "2018-06-01T21:14:00.974Z")
                .body(gson.toJson(lggson));

        Response response = request.when().post("/auth/mobile/login");
        response.prettyPrint();

        response.then().statusCode(200);

        token = response.getBody().path("data.token.access_token");
        System.out.println(token);



    }
}