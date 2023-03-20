package com.spring.cloud.gateway.resp;

import lombok.Data;

@Data
public class UserResp<T> {

    private String encryptData;
    private T data;

}
