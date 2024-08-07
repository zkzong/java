package com.example.powermock.resp;

import lombok.Data;

/**
 * @Author: zong
 * @Date: 2021/7/5
 */
@Data
public class UserResp<T> {
    private String code;
    private String msg;
    private T data;
}
