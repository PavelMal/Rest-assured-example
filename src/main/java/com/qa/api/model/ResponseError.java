package com.qa.api.model;

import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@AllArgsConstructor
@Getter
@Setter
public class ResponseError {

    private String message;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResponseError that = (ResponseError) o;
        return Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message);
    }
}