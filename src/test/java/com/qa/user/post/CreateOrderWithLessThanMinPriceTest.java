package com.qa.user.post;

import com.qa.api.model.Order;
import io.qameta.allure.Story;
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

public class CreateOrderWithLessThanMinPriceTest {

    @Story("Price")
    @Test(description = "Create an order with less than MIN price")
    public void createOrderWithLessThanMinPrice() {

        Order createdOrder = new Order("test", Long.MIN_VALUE - 1);

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