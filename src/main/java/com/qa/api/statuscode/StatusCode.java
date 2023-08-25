package com.qa.api.statuscode;

public enum StatusCode {

    OK(200),
    BAD_REQUEST(400),
    NOT_FOUND(404);

    public int value;

    private StatusCode(int code) {this.value = code;}
}