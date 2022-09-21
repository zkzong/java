package org.example.sj3.jpa.service.impl;

import org.example.sj3.jpa.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
    public void findDistinctByUserId() {
        orderService.findDistinctByUserId(111);
    }
}