package com.zkzong.sj.mybatis.repository;

import com.zkzong.sj.mybatis.entity.Order;
import com.zkzong.sj.mybatis.entity.OrderItem;

import java.util.List;

public interface OrderItemRepository {

    void createIfNotExistsTable();

    void truncateTable();

    Long insert(OrderItem model);

    void delete(Long orderItemId);

    void dropTable();

    List<Order> selectAll();
}
