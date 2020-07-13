package com.zkzong.sj.mybatis.repository;

import com.zkzong.sj.mybatis.entity.Order;

public interface OrderRepository {

    void createIfNotExistsTable();

    void truncateTable();

    Long insert(Order model);

    void delete(Long orderId);

    void dropTable();
}
