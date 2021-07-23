package com.zkzong.sj5.service;

import com.zkzong.sj5.entity.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.SQLException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceTest {

    @Autowired
    private ExampleService exampleService;

    @Test
    public void initEnvironment() throws SQLException {
        exampleService.initEnvironment();
    }

    @Test
    public void processSuccess() throws SQLException {
        exampleService.processSuccess();
    }

    @Test
    public void selectRange() {
        List<Order> orders = exampleService.selectRange();
        System.out.println(orders);
    }

    @Test
    public void cleanEnvironment() throws SQLException {
        exampleService.cleanEnvironment();
    }
}
