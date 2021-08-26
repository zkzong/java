package com.zkzong.sb.redis;

import com.zkzong.sb.redis.domain.Person;
import com.zkzong.sb.redis.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.TimeUnit;

/**
 * Created by Zong on 2017/5/10.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RedisApplicationTest {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate<String, User> redisTemplate;
    @Autowired
    private RedisTemplate<String, Person> redisTemplate1;

    @Test
    public void test() {
        stringRedisTemplate.opsForValue().set("aaa", "111");
        Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));
    }

    @Test
    public void testRedisTemplate() {
        User u = new User("zong", 30);
        redisTemplate.opsForValue().set("zong", u);
        System.out.println(redisTemplate.opsForValue().get("zong"));

        User user = new User("超人", 20);
        redisTemplate.opsForValue().set(user.getUsername(), user);
        user = new User("蝙蝠侠", 30);
        redisTemplate.opsForValue().set(user.getUsername(), user);
        user = new User("蜘蛛侠", 40);
        redisTemplate.opsForValue().set(user.getUsername(), user);
        Assert.assertEquals(20, redisTemplate.opsForValue().get("超人").getAge().longValue());
        Assert.assertEquals(30, redisTemplate.opsForValue().get("蝙蝠侠").getAge().longValue());
        Assert.assertEquals(40, redisTemplate.opsForValue().get("蜘蛛侠").getAge().longValue());

        Person p = new Person("mo", 1);
        redisTemplate1.opsForValue().set("mo", p);
        System.out.println(redisTemplate.opsForValue().get("mo"));
    }

    /**
     * 自增时不用判断key是否存在
     */
    @Test
    public void incr() {
        redisTemplate.opsForValue().increment("aaa", 1);
        redisTemplate.expire("aaa", 1, TimeUnit.MINUTES);
    }
}
