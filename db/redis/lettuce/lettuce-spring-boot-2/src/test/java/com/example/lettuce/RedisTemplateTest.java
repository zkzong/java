package com.example.lettuce;

import com.example.lettuce.config.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTemplateTest {

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

    @Test
    public void setString() {
        redisTemplate.opsForValue().set("name", "张三");
        Object name = redisTemplate.opsForValue().get("name");
        System.out.println(name);
    }

    @Test
    public void setObject() {
        User user = new User();
        user.setName("张三");
        user.setAge(30);
        redisTemplate.opsForValue().set("user", user);
        User userResult = (User) redisTemplate.opsForValue().get("user");
        System.out.println(userResult);
    }

    @Test
    public void range() {
        ListOperations list = redisTemplate.opsForList();
        list.leftPush("user", "name");
        list.leftPush("user", "age");
        list.leftPush("user", "name", "sex");

        List result = list.range("user", 0, -1);
        System.out.println(result);
    }
}
