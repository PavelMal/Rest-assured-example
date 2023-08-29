package com.qa.user.get;

import com.qa.api.model.Order;
import io.restassured.response.Response;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.qa.api.Response.CustomResponse.getResponseBodyAs;
import static com.qa.api.assertion.StatusCode.checkStatusCode;
import static com.qa.api.request.Request.doGet;
import static com.qa.api.request.Request.doPost;
import static com.qa.api.statuscode.StatusCode.NOT_FOUND;
import static com.qa.api.url.OrderUrl.CREATE_ORDER;
import static com.qa.api.url.OrderUrl.GET_ORDER;

public class GetOrderByPathParamTest {

    @BeforeMethod(description = "Create order before execution")
    public void createOrder(ITestContext context) {

        Order createdOrder = new Order("test", 1L);
        Response response = doPost(CREATE_ORDER, createdOrder);
        Order createdOrderResponse = getResponseBodyAs(response, Order.class);

        // Set orderId to created order and pass it to ITestContext for reusing in Test
        createdOrder.setId(createdOrderResponse.getId());
        context.setAttribute("order", createdOrder);
    }

    @Test(description = "Get order by path param")
    public void getOrderByPathParam(ITestContext context) {
        Order order = (Order) context.getAttribute("order");

        Response response = doGet(GET_ORDER + "/" + order.getId(), (Integer) null);

        checkStatusCode(NOT_FOUND, response.statusCode());
    }
}