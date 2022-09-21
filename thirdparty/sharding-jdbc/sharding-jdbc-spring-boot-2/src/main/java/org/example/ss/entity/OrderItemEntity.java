package org.example.ss.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_order_item")
public final class OrderItemEntity extends OrderItem {

    private static final long serialVersionUID = 5685474394188443341L;

    @Id
    @Column(name = "order_item_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Override
    public long getOrderItemId() {
        return super.getOrderItemId();
    }

    @Column(name = "order_id")
    @Override
    public long getOrderId() {
        return super.getOrderId();
    }

    @Column(name = "user_id")
    @Override
    public int getUserId() {
        return super.getUserId();
    }

    @Column(name = "status")
    @Override
    public String getStatus() {
        return super.getStatus();
    }
}
