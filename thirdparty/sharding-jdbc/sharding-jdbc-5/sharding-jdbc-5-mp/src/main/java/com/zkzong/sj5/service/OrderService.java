package com.zkzong.ss.service;

import com.github.pagehelper.PageInfo;
import com.zkzong.ss.entity.Order;

import java.util.List;

public interface OrderService {

    void insert();

    List<Order> list();

    PageInfo<Order> page();

}
