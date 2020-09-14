package com.zkzong.idempotent;

public enum ResponseCode {
    ILLEGAL_ARGUMENT(100, "illegal_argument"),
    REPETITIVE_OPERATION(100, "repetitive_operation");

    private int code;
    private String msg;

    ResponseCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
