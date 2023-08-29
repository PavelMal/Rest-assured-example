package com.qa.api.listener;

import org.testng.ITestContext;
import org.testng.ITestListener;

import static com.qa.api.request.Request.doPost;
import static com.qa.api.url.OrderUrl.CLEAR_ORDERBOOK;

public class Listener implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
        doPost(CLEAR_ORDERBOOK, null);
    }

    @Override
    public void onFinish(ITestContext context) {
        doPost(CLEAR_ORDERBOOK, null);
    }
}