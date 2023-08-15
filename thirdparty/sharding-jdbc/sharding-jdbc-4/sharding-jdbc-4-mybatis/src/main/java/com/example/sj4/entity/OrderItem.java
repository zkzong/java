
package com.example.sj4.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class OrderItem implements Serializable {

    private Long orderItemId;

    private Long orderId;

    private Integer userId;

    private String status;

}
