
package com.zkzong.sj4.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("t_order")
public class Order implements Serializable {

    private long orderId;

    private int userId;

    private long addressId;

    private String status;

}
