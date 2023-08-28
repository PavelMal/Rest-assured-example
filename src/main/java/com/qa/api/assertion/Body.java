package com.qa.api.assertion;

import com.qa.api.model.Order;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static com.qa.api.Response.CustomResponse.getResponseBodyAs;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

public class Body {

    @Step("Check response body is empty")
    public static void checkResponseBodyIsEmpty(Response response) {
        assertTrue(response.body().asString().isEmpty());
    }

    @Step("Check order ID in response body is not empty")
    public static void checkResponseOrderIdIsNotEmpty(Response response) {
        Order order = getResponseBodyAs(response, Order.class);
        Allure.addAttachment("OrderId", order.toString());
        assertNotNull(order.getId());
    }
}