package com.zkzong.sj4.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zkzong.sj4.entity.Order;
import com.zkzong.sj4.entity.OrderItem;
import com.zkzong.sj4.mapper.OrderItemMapper;
import com.zkzong.sj4.mapper.OrderMapper;
import com.zkzong.sj4.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderItemMapper orderItemMapper;

    @Override
    public void insert() {

        for (int i = 1; i <= 10; i++) {
            Order order = new Order();
            order.setOrderId(i);
            order.setUserId(i);
            order.setAddressId(i);
            order.setStatus("S");
            orderMapper.insert(order);

            OrderItem orderItem = new OrderItem();
            orderItem.setOrderItemId(i);
            orderItem.setOrderId(i);
            orderItem.setUserId(i);
            orderItem.setStatus("S");
            orderItemMapper.insert(orderItem);
        }

    }

    @Override
    public List<Order> list() {
        QueryWrapper<Order> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().gt(Order::getOrderId, 5);
        List<Order> orders = orderMapper.selectList(queryWrapper);
        return orders;
    }

    @Override
    public PageInfo<Order> page() {
        PageHelper.startPage(1, 2);
        QueryWrapper<Order> queryWrapper = new QueryWrapper<>();
        List<Order> orders = orderMapper.selectList(queryWrapper.lambda().orderByAsc(Order::getOrderId));
        PageInfo pageInfo = new PageInfo(orders);
        return pageInfo;
    }

    @Override
    public List<Order> betweenand() {
        QueryWrapper<Order> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().between(Order::getOrderId, 3, 5);
        List<Order> orders = orderMapper.selectList(queryWrapper);
        return orders;
    }
}
