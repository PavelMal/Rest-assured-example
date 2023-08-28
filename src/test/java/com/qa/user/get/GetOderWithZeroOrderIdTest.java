package com.qa.user.get;

import com.qa.api.url.OrderUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static com.qa.api.assertion.Body.checkResponseBodyIsEmpty;
import static com.qa.api.assertion.StatusCode.checkStatusCode;
import static com.qa.api.request.Request.doGet;
import static com.qa.api.statuscode.StatusCode.NOT_FOUND;

public class GetOderWithZeroOrderIdTest {

    @Test(description = "Get order by zero order ID")
    public void getOrderByZeroId() {
        Response response = doGet(OrderUrl.GET_ORDER, 0);

        checkStatusCode(NOT_FOUND, response.statusCode());
        checkResponseBodyIsEmpty(response);
    }
}