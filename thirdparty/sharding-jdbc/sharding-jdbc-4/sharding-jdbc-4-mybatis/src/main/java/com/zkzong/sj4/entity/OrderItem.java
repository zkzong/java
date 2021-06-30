
package com.zkzong.sj4.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class OrderItem implements Serializable {

    private long orderItemId;

    private long orderId;

    private int userId;

    private String status;

}
