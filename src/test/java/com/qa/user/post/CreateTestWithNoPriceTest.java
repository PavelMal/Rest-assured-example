package com.qa.user.post;

import com.qa.api.model.Order;
import com.qa.api.model.ResponseError;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static com.qa.api.Response.ResponseErrorMessage.NEED_TO_PASS_PRICE;
import static com.qa.api.assertion.Body.checkResponseErrorEqualsExpectedError;
import static com.qa.api.assertion.StatusCode.checkStatusCode;
import static com.qa.api.request.Request.doPost;
import static com.qa.api.statuscode.StatusCode.BAD_REQUEST;
import static com.qa.api.url.OrderUrl.CREATE_ORDER;

public class CreateTestWithNoPriceTest {

    @Test(description = "Create an order with NO price")
    public void createOrderWithNoPrice() {

        Order createdOrder = new Order("test");

        Response response = doPost(CREATE_ORDER, createdOrder);
        ResponseError expectedError = new ResponseError(NEED_TO_PASS_PRICE);

        checkStatusCode(BAD_REQUEST, response.statusCode());
        checkResponseErrorEqualsExpectedError(response, expectedError);
    }
}