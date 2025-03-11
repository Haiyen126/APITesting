package Api.example;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetServiceType {

    @Test
    public void GetServiceTypeSucess(){
        RequestSpecification request = given()
                .baseUri("https://bidv.net:9303/bidvorg/service/open-banking/ibank2-sit")
                .accept("application/json")
                .contentType("application/json")
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
                .header("Authorization", "Bearer " + Login.token)
                .body(" \"subProductId\": \"52\"");

        Response response = request.when().post("/cnr/par/service-type/list/1.0");
        response.prettyPrint();
        response.then().statusCode(200);
    }
}
