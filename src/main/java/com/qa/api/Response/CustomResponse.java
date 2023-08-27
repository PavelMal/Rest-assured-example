package com.qa.api.Response;

import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;

public class CustomResponse {

    public static <T> T getResponseBodyAs(Response response, Class<T> tClass) {
        return response.getBody().as(tClass, ObjectMapperType.GSON);
    }
}