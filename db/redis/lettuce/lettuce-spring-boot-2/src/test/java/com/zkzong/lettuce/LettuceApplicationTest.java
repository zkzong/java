package com.zkzong.lettuce;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LettuceApplicationTest {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private LettuceConnectionFactory lettuceConnectionFactory;

    @Test
    public void set() {
        String key = "test:1:count";
        ValueOperations valueOperations = redisTemplate.opsForValue();
        valueOperations.set(key, 10, 10, TimeUnit.MINUTES);
        String s = valueOperations.get(key).toString();
        System.out.println(s);
        Long increment = valueOperations.increment(key);
        System.out.println(increment);

        lettuceConnectionFactory.getClientConfiguration();

    }
}