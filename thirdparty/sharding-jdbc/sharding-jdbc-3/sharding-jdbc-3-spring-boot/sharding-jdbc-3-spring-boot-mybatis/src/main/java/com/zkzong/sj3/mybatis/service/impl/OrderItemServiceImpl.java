package com.zkzong.sj3.mybatis.service.impl;

import com.zkzong.sj3.mybatis.entity.Order;
import com.zkzong.sj3.mybatis.entity.OrderItem;
import com.zkzong.sj3.mybatis.mapper.OrderItemMapper;
import com.zkzong.sj3.mybatis.mapper.OrderMapper;
import com.zkzong.sj3.mybatis.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderItemServiceImpl implements OrderItemService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderItemMapper orderItemMapper;

    @Override
    public void insertOrderItem() {
        List<Long> orderIds = new ArrayList<>(10);
        System.out.println("1.Insert--------------");
        for (int i = 0; i < 10; i++) {
            Order order = new Order();
            order.setUserId(51);
            order.setStatus("INSERT_TEST");
            orderMapper.insert(order);
            long orderId = order.getOrderId();
            orderIds.add(orderId);

            OrderItem item = new OrderItem();
            item.setOrderId(orderId);
            item.setUserId(51);
            item.setStatus("INSERT_TEST");
            orderItemMapper.insert(item);
        }
        System.out.println(orderItemMapper.selectAll());
        System.out.println("2.Delete--------------");
//        for (Long each : orderIds) {
//            orderRepository.delete(each);
//            orderItemRepository.delete(each);
//        }
        System.out.println(orderItemMapper.selectAll());
//        orderItemRepository.dropTable();
//        orderRepository.dropTable();
    }
}
