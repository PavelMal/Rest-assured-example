package com.qa.api.assertion;

import io.qameta.allure.Step;
import io.restassured.response.Response;

import static org.testng.Assert.assertTrue;

public class Body {

    @Step("Check response body is empty")
    public static void checkResponseBodyIsEmpty(Response response) {
        assertTrue(response.body().asString().isEmpty());
    }
}