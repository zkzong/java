package com.example.ss.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_order")
public final class OrderEntity extends Order {

    private static final long serialVersionUID = 4743102234543827854L;

    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Override
    public long getOrderId() {
        return super.getOrderId();
    }

    @Column(name = "user_id")
    @Override
    public int getUserId() {
        return super.getUserId();
    }

    @Column(name = "address_id")
    @Override
    public long getAddressId() {
        return super.getAddressId();
    }

    @Column(name = "status")
    @Override
    public String getStatus() {
        return super.getStatus();
    }
}
