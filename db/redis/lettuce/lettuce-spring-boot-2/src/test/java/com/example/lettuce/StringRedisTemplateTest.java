package com.example.lettuce;

import com.example.lettuce.config.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StringRedisTemplateTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void set() {
        stringRedisTemplate.opsForValue().set("name", "张三");
        String name = stringRedisTemplate.opsForValue().get("name");
        System.out.println(name);
    }

    @Test
    public void setObject() throws IOException {
        User user = new User();
        user.setName("张三");
        user.setAge(30);
        String json = objectMapper.writeValueAsString(user);
        stringRedisTemplate.opsForValue().set("user", json);

        String userJson = stringRedisTemplate.opsForValue().get("user");
        User u = objectMapper.readValue(userJson, User.class);
        System.out.println(u);
    }

}
