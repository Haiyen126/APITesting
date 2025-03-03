package Api.example;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class loginIBank {
    @Test
    public void Login(){
        String payload = "{\n" +
                "    \"password\": \"Abcd@54321\",\n" +
                "    \"username\": \"88060ktv\",\n" +
                "    \"deviceId\": \"959B7B6E-4281-4CBF-99ED-54ECAA4C61D5\",\n" +
                "    \"clientPublicKey\": \"MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA0L8aOXk\\/wL9InjIb2QQUHHDreXL3aJpQucsE1PMczj4RoKGuEmcxGIopTo6gHc\\/K9XN7NxuK9o7RKnxwqRts9ILaXr8JEzHcnVmuA2f\\/Ld3uoYO+Tn86u9mJVHhEQpqqoMKhsMUj9EBXe1eY64c0W8Ndpc5LsfFYng\\/mvi\\/hICKqbbFUu7TP48qO9rzFlZjmqHgcyhiOIZFAqGEHBMr++pmBmIdQa1z9u3sqV8nKB47GvCP7wfes7D7RLW8DxDGrZ1IXqbhW5QojoVw4c2gfHsna3hzeXwGaX\\/tF\\/CI8c8PRU5rieTz\\/Vf6jqiGbvDsFsWxOv2ZUbOeQlLao3sNikQIDAQAB\"\n" +
                "}";
        RestAssured.baseURI = "https://bidv.net:9303/bidvorg/service/open-banking/ibank2-sit";
//        ---chưa sử dụng testNG------
//        given()
//                .header ("X-Forwarded-For", "10.21.101.126")
//                .header ("Channel", "IBANK2")
//                .header ("Accept-Language", "vi-vn")
//                .header ("X-API-Interaction-ID", "128937612989")
//                .header ("X-Client-ID", "635bdf50465dce92380c15b9c19d8c51")
//                .header ("I-Mobile", "True")
//                .header ("I-Client-ID", "APP")
//                .header ("I-Device-ID", "027E15E4-AD4B-4612-84A6-6711D241226B")
//                .header ("I-Version", "1.0.0")
//                .header ("I-Encrypted", "false")
//                .header ("I-Os", "Android")
//                .header ("I-Os-Version", "17.1.1")
//                .header ("I-Device-Model", "MD12343")
//                .header ("Timestamp", "2018-06-01T21:14:00.974Z")
//                .body (payload)
//                .when()
//                .post("/auth/mobile/login")
//                .then()
//                .statusCode(200)
//                .contentType(ContentType.JSON)
//                .body("message", equalTo("SUCCESS"))
//                .body("data.username",equalTo("88060ktv"));
//        ----sử dụng testNG----------------------------------
        Response response = given()
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
                .body (payload)
                .when()
                .post("/auth/mobile/login");
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().getString("message"), "SUCCESS");
        Assert.assertEquals(response.jsonPath().getString("data.username"), "88060ktv");


    }
}
