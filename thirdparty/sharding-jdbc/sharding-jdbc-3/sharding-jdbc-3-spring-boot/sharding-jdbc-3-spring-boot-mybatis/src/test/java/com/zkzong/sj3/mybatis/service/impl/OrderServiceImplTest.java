package com.zkzong.sj3.mybatis.service.impl;

import com.zkzong.sj3.mybatis.entity.Order;
import com.zkzong.sj3.mybatis.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @Author: Zong
 * @Date: 2018/12/16
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class OrderServiceImplTest {

    @Autowired
    private OrderService orderService;

    @Test
    public void insertOrder() {
        orderService.insertOrder();
    }

    @Test
    public void findInSet() {
        List<Order> orderList = orderService.findInSet("s");
        System.out.println(orderList);
    }
}
