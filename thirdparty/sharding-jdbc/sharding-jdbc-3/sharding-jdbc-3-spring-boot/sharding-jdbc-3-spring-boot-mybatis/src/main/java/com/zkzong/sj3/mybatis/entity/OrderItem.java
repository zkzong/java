package org.example.sj3.mybatis.entity;

import lombok.Data;

@Data
public class OrderItem {

    private long orderItemId;

    private long orderId;

    private int userId;

    private String status;

}
