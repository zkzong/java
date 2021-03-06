package com.zkzong.sj.service.impl;

import com.zkzong.sj.entity.Order;
import com.zkzong.sj.entity.OrderItem;
import com.zkzong.sj.repository.OrderItemRepository;
import com.zkzong.sj.repository.OrderRepository;
import com.zkzong.sj.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public void inertOrder() {
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
//        System.out.println("2.Delete--------------");
//        if (orderItems.size() > 0) {
//            for (Long each : orderItemIds) {
//                orderItemRepository.delete(each);
//            }
//            for (Long each : orderIds) {
//                orderRepository.delete(each);
//            }
//        }
        System.out.println(orderItemRepository.findAll());
    }
}
