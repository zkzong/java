package com.zkzong.sj.mybatis.service;

import com.zkzong.sj.mybatis.entity.Order;
import com.zkzong.sj.mybatis.entity.OrderItem;
import com.zkzong.sj.mybatis.repository.OrderItemRepository;
import com.zkzong.sj.mybatis.repository.OrderRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:mybatisShardingDatabaseOnlyContext.xml"})
public class DatabaseOrderServiceTest {

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
            item.setOrderId(i);
            item.setUserId(51);
            item.setStatus("INSERT_TEST");
            orderItemRepository.insert(item);
        }
    }
}