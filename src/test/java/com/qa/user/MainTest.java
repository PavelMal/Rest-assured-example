package com.qa.user;


import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class MainTest {

    @Test
    public void checkResponse() {
        RestAssured.get("http://localhost:8080/api/check").then().statusCode(200);
    }
}
