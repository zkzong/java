package com.zkzong.ss.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zkzong.ss.entity.Order;
import com.zkzong.ss.entity.OrderItem;
import com.zkzong.ss.mapper.OrderItemMapper;
import com.zkzong.ss.mapper.OrderMapper;
import com.zkzong.ss.service.OrderService;
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
            order.setStatus("S");
            orderMapper.insert(order);

            //OrderItem orderItem = new OrderItem();
            //orderItem.setOrderItemId(i);
            //orderItem.setOrderId(i);
            //orderItem.setUserId(i);
            //orderItemMapper.insert(orderItem);
        }

    }

    @Override
    public List<Order> list() {
        QueryWrapper<Order> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(Order::getOrderId, 5);
        //queryWrapper.lambda().gt(Order::getOrderId, 5);
        //queryWrapper.lambda().between(Order::getOrderId, 2, 5);
        List<Order> orders = orderMapper.selectList(queryWrapper);
        return orders;
    }

    @Override
    public PageInfo<Order> page() {
        PageHelper.startPage(1, 2);
        QueryWrapper<Order> queryWrapper = new QueryWrapper<>();
        List<Order> orders = orderMapper.selectList(queryWrapper);
        PageInfo pageInfo = new PageInfo(orders);
        return pageInfo;
    }
}
