package com.zkzong.sj4.service;

import com.github.pagehelper.PageInfo;
import com.zkzong.sj4.entity.Order;

import java.util.List;

public interface OrderService {

    void insert();

    List<Order> list();

    PageInfo<Order> page();

    List<Order> betweenand();

}
