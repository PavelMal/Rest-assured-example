package com.qa.user.get;

import com.qa.api.model.Order;
import com.qa.api.url.OrderUrl;
import io.restassured.response.Response;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;

import static com.qa.api.Response.CustomResponse.getResponseBodyAs;
import static com.qa.api.assertion.Order.checkOrders;
import static com.qa.api.assertion.StatusCode.checkStatusCode;
import static com.qa.api.request.Request.doGet;
import static com.qa.api.request.Request.doPost;
import static com.qa.api.statuscode.StatusCode.OK;
import static com.qa.api.url.OrderUrl.CREATE_ORDER;

public class GetOrderWithExtraQueryParamTest {

    @BeforeMethod(description = "Create order before execution")
    public void createOrder(ITestContext context) {

        Order createdOrder = new Order("test", 1L);
        Response response = doPost(CREATE_ORDER, createdOrder);
        Order createdOrderResponse = getResponseBodyAs(response, Order.class);

        // Set orderId to created order and pass it to ITestContext for reusing in Test
        createdOrder.setId(createdOrderResponse.getId());
        context.setAttribute("order", createdOrder);
    }

    @Test(description = "Get order with extra query param")
    public void getOrderWithExtraQueryParam(ITestContext context) {
        Order expectedOrder = (Order) context.getAttribute("order");

        HashMap<String, Object> queryParams = new HashMap<>();
        queryParams.put("id", expectedOrder.getId());
        queryParams.put("test", "test");
        Response response = doGet(OrderUrl.GET_ORDER, queryParams);

        Order actualOrder = getResponseBodyAs(response, Order.class);

        checkStatusCode(OK, response.statusCode());
        checkOrders(expectedOrder, actualOrder);
    }
}