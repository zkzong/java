package com.zkzong.sj3.mybatis.service;

import com.zkzong.sj3.mybatis.entity.Order;

import java.util.List;

public interface OrderService {
    void insertOrder();

    List<Order> findInSet(String status);
}
