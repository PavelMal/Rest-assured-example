package com.qa.api.assertion;

import com.qa.api.model.Order;
import com.qa.api.model.ResponseError;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.testng.Assert;

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

    @Step("Check response and expected errors are equal")
    public static void checkResponseErrorEqualsExpectedError(Response response, ResponseError expectedError) {
        ResponseError error = getResponseBodyAs(response, ResponseError.class);
        Allure.addAttachment("Actual error", error.toString());
        Assert.assertEquals(error, expectedError);
    }
}