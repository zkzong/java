package com.example.tx.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TxServiceTest {

    @Autowired
    private TxService txService;

    @Test(expected = ArithmeticException.class)
    public void insertAll() {
        txService.insertAll("hehe", 20);
    }

    @Test(expected = ArithmeticException.class)
    public void insertMysqlThenRedis() {
        txService.insertMysqlThenRedis("hehe", 20);
    }

}