package org.example.sj3.jpa.service.impl;

import org.example.sj3.jpa.entity.Order;
import org.example.sj3.jpa.entity.OrderItem;
import org.example.sj3.jpa.repository.OrderItemRepository;
import org.example.sj3.jpa.repository.OrderRepository;
import org.example.sj3.jpa.service.OrderItemService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderItemServiceImpl implements OrderItemService {

    @Resource
    private OrderRepository orderRepository;

    @Resource
    private OrderItemRepository orderItemRepository;

    @Override
    public void insertOrderItem() {
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
}
