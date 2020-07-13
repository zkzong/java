package com.zkzong.sj.jpa.service;

import com.zkzong.sj.jpa.entity.Order;
import com.zkzong.sj.jpa.entity.OrderItem;
import com.zkzong.sj.jpa.repository.OrderItemRepository;
import com.zkzong.sj.jpa.repository.OrderRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:jpaShardingTableOnlyContext.xml"})
public class TableOrderServiceTest {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Test
    public void addOrder() {
        for (int i = 0; i < 10; i++) {
            Order order = new Order();
            order.setOrderId(i);
            order.setUserId(51);
            order.setStatus("INSERT_TEST");
            orderRepository.insert(order);
            long orderId = order.getOrderId();

            OrderItem item = new OrderItem();
            item.setOrderItemId(i);
            item.setOrderId(orderId);
            item.setUserId(51);
            orderItemRepository.insert(item);
        }
    }
}