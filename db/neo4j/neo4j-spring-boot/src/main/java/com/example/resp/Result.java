package com.example.resp;

import lombok.Data;

@Data
public class Result<T> {

    private String code;
    private String message;
    private T data;

    public Result() {
    }

    public Result(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public Result(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Result(ResultEnum resultEnum, T data) {
        this.code = resultEnum.getCode();
        this.message = resultEnum.getMessage();
        this.data = data;
    }

    public static Result ok() {
        return response(ResultEnum.OK, null);
    }

    public static <T> Result ok(T data) {
        return response(ResultEnum.OK, data);
    }

    public static Result fail() {
        return response(ResultEnum.FAIL, null);
    }

    public static <T> Result fail(T data) {
        return response(ResultEnum.FAIL, data);
    }

    public static <T> Result<T> response(String code, String message, T data) {
        return new Result<>(code, message, data);
    }

    public static <T> Result<T> response(ResultEnum resultEnum, T data) {
        return new Result<>(resultEnum, data);
    }

}
