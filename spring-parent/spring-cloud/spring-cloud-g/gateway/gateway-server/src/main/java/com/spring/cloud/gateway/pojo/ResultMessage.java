package com.spring.cloud.gateway.pojo;

import lombok.Data;

@Data
public class ResultMessage {

    private boolean success;
    private String message;

    public ResultMessage(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

}
