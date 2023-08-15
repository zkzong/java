package com.example.sj3.mybatis.entity;

import lombok.Data;

@Data
public class Order {

    private long orderId;

    private int userId;

    private String status;

}
