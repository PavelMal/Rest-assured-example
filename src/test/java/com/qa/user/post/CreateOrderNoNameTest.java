package com.qa.user.post;

import com.qa.api.model.Order;
import com.qa.api.model.ResponseError;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static com.qa.api.Response.ResponseErrorMessage.NEED_TO_PASS_NAME;
import static com.qa.api.assertion.Body.checkResponseErrorEqualsExpectedError;
import static com.qa.api.assertion.StatusCode.checkStatusCode;
import static com.qa.api.request.Request.doPost;
import static com.qa.api.statuscode.StatusCode.BAD_REQUEST;
import static com.qa.api.url.OrderUrl.CREATE_ORDER;

public class CreateOrderNoNameTest {

    @Story("Name")
    @Test(description = "Create an order with no name")
    public void createOrderWithNoName() {

        Order createdOrder = new Order(1L);

        Response response = doPost(CREATE_ORDER, createdOrder);
        ResponseError expectedError = new ResponseError(NEED_TO_PASS_NAME);

        checkStatusCode(BAD_REQUEST, response.statusCode());
        checkResponseErrorEqualsExpectedError(response, expectedError);
    }
}