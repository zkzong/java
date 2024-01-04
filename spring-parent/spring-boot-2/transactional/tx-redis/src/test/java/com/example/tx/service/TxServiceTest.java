package com.example.tx.service;

import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import redis.embedded.RedisServer;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TxServiceTest {

    @Autowired
    private TxService txService;

    private static RedisServer redisServer;

    /**
     * 启动Redis，并在6379端口监听
     */
    @BeforeAll
    static void startRedis() {
        // https://github.com/kstyrc/embedded-redis/issues/51
        redisServer = RedisServer.builder()
                .port(6379)
                .setting("maxmemory 128M") //maxheap 128M
                .build();

        redisServer.start();
    }

    /**
     * 析构方法之后执行，停止Redis.
     */
    @AfterAll
    static void stopRedis() {
        redisServer.stop();
    }


    @Test(expected = ArithmeticException.class)
    public void insert() {
        txService.insert();
    }
}