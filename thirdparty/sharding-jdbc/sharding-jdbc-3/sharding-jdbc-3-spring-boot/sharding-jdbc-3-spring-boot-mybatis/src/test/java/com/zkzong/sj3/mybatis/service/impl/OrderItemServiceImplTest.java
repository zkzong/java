package org.example.sj3.mybatis.service.impl;

import org.example.sj3.mybatis.service.OrderItemService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author: Zong
 * @Date: 2018/12/16
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class OrderItemServiceImplTest {

    @Autowired
    private OrderItemService orderItemService;

    @Test
    public void insertOrderItem() {
    }
}