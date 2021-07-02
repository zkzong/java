package com.zkzong.ss.service;

import com.github.pagehelper.PageInfo;
import com.zkzong.sj4.ShardingJdbcApplication;
import com.zkzong.sj4.entity.Order;
import com.zkzong.sj4.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShardingJdbcApplication.class)
public class OrderServiceTest {

    @Autowired
    private OrderService orderService;

    @Test
    public void insert() {
        orderService.insert();
    }

    @Test
    public void list() {
        List<Order> list = orderService.list();
        System.out.println(list);
    }

    @Test
    public void page() {
        PageInfo<Order> page = orderService.page();
        System.out.println(page);
    }

}
