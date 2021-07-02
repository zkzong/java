
package com.zkzong.sj4.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("t_order_item")
public class OrderItem implements Serializable {

    private long orderItemId;

    private long orderId;

    private int userId;

    private String status;

}
