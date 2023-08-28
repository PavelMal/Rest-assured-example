package com.qa.user.get;

import com.qa.api.url.OrderUrl;
import io.restassured.response.Response;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.qa.api.assertion.StatusCode.checkStatusCode;
import static com.qa.api.request.Request.doGet;
import static com.qa.api.statuscode.StatusCode.BAD_REQUEST;

public class GerOrderIncorrectOrderIdParamTest {

    @DataProvider(name = "incorrectValues")
    public Object[][] incorrectValues() {
        return new Object [][] {
                {true},
                {"true"},
                {0.001},
                {"Some_value"},
                {" "},
                {""}
        };
    }


    @Test(description = "Get order by negative ID", dataProvider = "incorrectValues")
    public void getOrderByNegativeId(Object values) {
        Response response = doGet(OrderUrl.GET_ORDER, values);

        checkStatusCode(BAD_REQUEST, response.statusCode());
    }
}