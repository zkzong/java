package com.zkzong.sj.jpa.repository;

import com.zkzong.sj.jpa.entity.Order;

public interface OrderRepository {

    Long insert(Order order);

    void delete(Long orderId);
}
