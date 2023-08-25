package com.qa.api.Response;

import io.qameta.allure.Step;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;

public class CustomResponse {

    @Step("Deserialize response body into: {tClass}")
    public static <T> T getResponseBodyAs(Response response, Class<T> tClass) {
        return response.getBody().as(tClass, ObjectMapperType.GSON);
    }
}