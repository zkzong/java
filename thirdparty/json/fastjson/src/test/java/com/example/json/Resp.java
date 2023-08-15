package com.example.json;

import lombok.Data;

/**
 * @Author: zong
 * @Date: 2021/7/22
 */
@Data
public class Resp<T> {

    private String code;
    private String msg;
    private T data;
}
