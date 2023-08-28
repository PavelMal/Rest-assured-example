package com.qa.user.get;

import com.qa.api.url.OrderUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static com.qa.api.assertion.StatusCode.checkStatusCode;
import static com.qa.api.request.Request.doGet;
import static com.qa.api.statuscode.StatusCode.BAD_REQUEST;

public class GetOrdersTest {

    @Test(description = "Get orders")
    public void getNonExistentOrderById() {
        Response response = doGet(OrderUrl.GET_ORDER, null);

        checkStatusCode(BAD_REQUEST, response.statusCode());
    }
}