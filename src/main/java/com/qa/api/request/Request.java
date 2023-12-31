package com.qa.api.request;

import com.qa.api.model.Order;
import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class Request {

    @Step("Send GET request to url: {url}?id={orderId}")
    public static Response doGet(String url, Integer orderId) {
        if (orderId == null) {
            return given().filter(new AllureRestAssured()).get(url);
        }
        return given().filter(new AllureRestAssured()).queryParam("id", orderId).get(url);
    }

    @Step("Send GET request to url: {url}?id={orderId}")
    public static Response doGet(String url, Object orderId) {
        return given().filter(new AllureRestAssured()).queryParam("id", orderId).get(url);
    }

    @Step("Send GET request to url: {url}?id={orderId}")
    public static Response doGet(String url, Map<String, Object> queryParams) {
        return given().filter(new AllureRestAssured()).queryParams(queryParams).get(url);
    }

    @Step("Send POST request to url: {url}")
    public static Response doPost(String url, Order order) {
        if (order == null) {
            return given().filter(new AllureRestAssured()).contentType(ContentType.JSON).post(url);
        }
        return given().filter(new AllureRestAssured()).body(order).contentType(ContentType.JSON).post(url);
    }
}