package com.zkzong.sj.jpa.repository;

import com.zkzong.sj.jpa.entity.OrderItem;

import java.util.List;

public interface OrderItemRepository {

    Long insert(OrderItem orderItemId);

    void delete(Long orderItemId);

    List<OrderItem> selectAll();
}
