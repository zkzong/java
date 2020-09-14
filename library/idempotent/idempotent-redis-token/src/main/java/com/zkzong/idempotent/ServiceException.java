package com.zkzong.idempotent;

public class ServiceException extends RuntimeException {

    private ResponseCode responseCode;

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(ResponseCode responseCode, int code) {
        super(responseCode.getMsg());
    }

}
