package com.qa.api.assertion;

import io.qameta.allure.Step;
import org.testng.Assert;

public class StatusCode {

    @Step("Check status code expected: {expectedStatusCode.value} and actual: {actualStatusCode}")
    public static void checkStatusCode(com.qa.api.statuscode.StatusCode expectedStatusCode, int actualStatusCode) {
        Assert.assertEquals(expectedStatusCode.value, actualStatusCode);
    }
}