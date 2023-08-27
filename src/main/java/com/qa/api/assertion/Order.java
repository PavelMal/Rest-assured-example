package com.qa.api.assertion;

import io.qameta.allure.Step;

import static org.testng.Assert.assertEquals;

public class Order {

    @Step("Check order ID: expected: {expectedOrderId} actual: {actualOrderId}")
    public static void checkOrderId(int expectedOrderId, int actualOrderId) {
        assertEquals(actualOrderId, expectedOrderId);
    }
}