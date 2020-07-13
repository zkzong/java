package com.zkzong.sj3.jpa.service.impl;

import com.zkzong.sj3.jpa.entity.Order;
import com.zkzong.sj3.jpa.entity.OrderItem;
import com.zkzong.sj3.jpa.repository.OrderItemRepository;
import com.zkzong.sj3.jpa.repository.OrderRepository;
import com.zkzong.sj3.jpa.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderRepository orderRepository;

    @Resource
    private OrderItemRepository orderItemRepository;

    @Override
    public void insertOrder() {
        List<Long> orderIds = new ArrayList<>(10);
        List<Long> orderItemIds = new ArrayList<>(10);
        System.out.println("1.Insert--------------");
        for (int i = 0; i < 10; i++) {
            Order order = new Order();
            order.setUserId(51);
            order.setStatus("INSERT_TEST");
            long orderId = orderRepository.save(order).getOrderId();
            orderIds.add(orderId);
            OrderItem item = new OrderItem();
            item.setOrderId(orderId);
            item.setUserId(51);
            orderItemIds.add(orderItemRepository.save(item).getOrderItemId());
        }
        List<OrderItem> orderItems = orderItemRepository.findAll();
        System.out.println(orderItemRepository.findAll());
        System.out.println("2.Delete--------------");

        System.out.println(orderItemRepository.findAll());
    }

    @Override
    public void findDistinctByUserId(Integer userId) {
        orderRepository.findDistinctByUserId(userId);
    }
}
