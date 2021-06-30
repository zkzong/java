package com.zkzong.sj4.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.SQLException;

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
    public void cleanEnvironment() throws SQLException {
        exampleService.cleanEnvironment();
    }
}
