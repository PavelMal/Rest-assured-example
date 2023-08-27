package com.qa.user.post;

import com.qa.api.Response.CustomResponse;
import com.qa.api.model.Order;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.qa.api.Response.CustomResponse.getResponseBodyAs;
import static com.qa.api.assertion.Order.checkOrderId;
import static com.qa.api.assertion.StatusCode.checkStatusCode;
import static com.qa.api.request.Request.doGet;
import static com.qa.api.request.Request.doPost;
import static com.qa.api.statuscode.StatusCode.OK;
import static com.qa.api.url.OrderUrl.CLEAR_ORDERBOOK;
import static com.qa.api.url.OrderUrl.CREATE_ORDER;

public class CreateOrderTest {

    @BeforeTest(description = "Clear orders before execution")
    public void setUp() {
        doPost(CLEAR_ORDERBOOK, null);
    }

    @Test(description = "Create an order correct params")
    public void getNonExistentOrderById() {

        Order createdOrder = new Order("test", 1L);

        Response response = doPost(CREATE_ORDER, createdOrder);

        checkStatusCode(OK, response.statusCode());

        Order createdOrderResponse = getResponseBodyAs(response, Order.class);

        checkOrderId(1, createdOrderResponse.getId());
    }
}