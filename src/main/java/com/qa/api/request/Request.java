package com.qa.api.request;

import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Request {

    @Step("Send GET request to url: {url}?id={orderId}")
    public static Response doGet(String url, String orderId) {
        return given().filter(new AllureRestAssured()).queryParam("id", orderId).get(url);
    }
}