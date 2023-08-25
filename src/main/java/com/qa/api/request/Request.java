package com.qa.api.request;

import com.qa.api.model.Order;
import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Request {

    @Step("Send GET request to url: {url}?id={orderId}")
    public static Response doGet(String url, String orderId) {
        return given().filter(new AllureRestAssured()).queryParam("id", orderId).get(url);
    }

    @Step("Send POST request to url: {url}")
    public static Response doPost(String url, Order order) {
        return given().filter(new AllureRestAssured()).body(order).post(url);
    }
}