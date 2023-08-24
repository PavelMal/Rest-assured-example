package com.qa.api.url;

import com.qa.api.endpoint.Order;

import static com.qa.api.url.Common.COMMON_URL_PART;

public class OrderUrl {

    public static final String GET_ORDER = COMMON_URL_PART + Order.GET_ORDER;
    public static final String CREATE_ORDER = COMMON_URL_PART + Order.CREATE_ORDER;
}