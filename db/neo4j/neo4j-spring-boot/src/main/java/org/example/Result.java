package org.example;

import lombok.Data;

@Data
public class Result<T> {

    private Integer code;
    private String message;
    private T data;

    public static Result ok() {
        return new Result();
    }

    public static <T> Result ok(T data) {
        Result result = new Result();
        result.setData(data);
        return result;
    }
}
