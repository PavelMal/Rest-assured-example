package com.qa.user.post;

import com.qa.api.Response.CustomResponse;
import com.qa.api.model.Order;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static com.qa.api.assertion.StatusCode.checkStatusCode;
import static com.qa.api.request.Request.doPost;
import static com.qa.api.statuscode.StatusCode.OK;
import static com.qa.api.url.OrderUrl.CREATE_ORDER;

public class CreateOrderTest {

    @Test(description = "Create an order correct params")
    public void getNonExistentOrderById() {

        Order createdOrder = new Order("test", 1L);

        Response response = doPost(CREATE_ORDER, createdOrder);

        checkStatusCode(OK, response.statusCode());

        Order createdOrderResponse = CustomResponse.getResponseBodyAs(response, Order.class);


    }
}