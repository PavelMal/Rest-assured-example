package com.qa.user.post;

import com.qa.api.model.Order;
import com.qa.api.model.ResponseError;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static com.qa.api.Response.ResponseErrorMessage.PRICE_LESS_OR_EQUAL_ZERO;
import static com.qa.api.assertion.Body.checkResponseErrorEqualsExpectedError;
import static com.qa.api.assertion.StatusCode.checkStatusCode;
import static com.qa.api.request.Request.doPost;
import static com.qa.api.statuscode.StatusCode.BAD_REQUEST;
import static com.qa.api.url.OrderUrl.CREATE_ORDER;

public class CreateOrderWithZeroPriceTest {

    @Story("Price")
    @Test(description = "Create an order with zero price")
    public void createOrderWithZeroPrice() {

        Order createdOrder = new Order("test", 0L);

        Response response = doPost(CREATE_ORDER, createdOrder);

        ResponseError expectedError = new ResponseError(PRICE_LESS_OR_EQUAL_ZERO);

        checkStatusCode(BAD_REQUEST, response.statusCode());
        checkResponseErrorEqualsExpectedError(response, expectedError);
    }
}