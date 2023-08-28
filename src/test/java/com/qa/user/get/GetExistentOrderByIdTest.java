package com.qa.user.get;

import com.qa.api.model.Order;
import com.qa.api.url.OrderUrl;
import io.restassured.response.Response;
import org.testng.ITestContext;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.qa.api.Response.CustomResponse.getResponseBodyAs;
import static com.qa.api.assertion.Order.checkOrders;
import static com.qa.api.assertion.StatusCode.checkStatusCode;
import static com.qa.api.request.Request.doGet;
import static com.qa.api.request.Request.doPost;
import static com.qa.api.statuscode.StatusCode.OK;
import static com.qa.api.url.OrderUrl.CREATE_ORDER;

public class GetExistentOrderByIdTest {

    @BeforeTest(description = "Create order before execution")
    public void createOrder(ITestContext context) {

        Order createdOrder = new Order("test", 1L);
        Response response = doPost(CREATE_ORDER, createdOrder);
        Order createdOrderResponse = getResponseBodyAs(response, Order.class);

        // Set orderId to created order and pass it to ITestContext for reusing in Test
        createdOrder.setId(createdOrderResponse.getId());
        context.setAttribute("order", createdOrder);
    }

    @Test(description = "Get existent order by ID")
    public void getExistentOrderById(ITestContext context) {
        Order expectedOrder = (Order) context.getAttribute("order");
        Response response = doGet(OrderUrl.GET_ORDER, expectedOrder.getId());
        Order actualOrder = getResponseBodyAs(response, Order.class);

        checkStatusCode(OK, response.statusCode());
        checkOrders(expectedOrder, actualOrder);
    }
}