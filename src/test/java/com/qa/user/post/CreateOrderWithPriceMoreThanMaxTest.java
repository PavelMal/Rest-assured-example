package com.qa.user.post;

import com.qa.api.model.Order;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static com.qa.api.Response.CustomResponse.getResponseBodyAs;
import static com.qa.api.assertion.Body.checkResponseOrderIdIsNotEmpty;
import static com.qa.api.assertion.Order.checkOrders;
import static com.qa.api.assertion.StatusCode.checkStatusCode;
import static com.qa.api.request.Request.doGet;
import static com.qa.api.request.Request.doPost;
import static com.qa.api.statuscode.StatusCode.OK;
import static com.qa.api.url.OrderUrl.CREATE_ORDER;
import static com.qa.api.url.OrderUrl.GET_ORDER;

public class CreateOrderWithPriceMoreThanMaxTest {

    @Test(description = "Create an order with MAX price")
    public void createOrderWithMaxPrice() {

        Order createdOrder = new Order("test", Long.MAX_VALUE);

        Response response = doPost(CREATE_ORDER, createdOrder);

        checkStatusCode(OK, response.statusCode());

        Order createdOrderResponse = getResponseBodyAs(response, Order.class);

        int expectedOrderId = createdOrderResponse.getId();

        checkResponseOrderIdIsNotEmpty(response);

        // Check order after creation by GET method

        Response responseAfterCreatingOrder = doGet(GET_ORDER, expectedOrderId);
        Order orderAfterCreation = getResponseBodyAs(responseAfterCreatingOrder, Order.class);
        createdOrder.setId(expectedOrderId);

        checkOrders(createdOrder, orderAfterCreation);
    }
}