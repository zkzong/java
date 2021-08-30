package com.zkzong.sb.redis;

import com.zkzong.sb.redis.domain.Person;
import com.zkzong.sb.redis.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
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
    private RedisTemplate<String, User> userRedisTemplate;
    @Autowired
    private RedisTemplate<String, Person> personRedisTemplate;
    @Autowired
    private RedisTemplate<String, Integer> integerRedisTemplate;

    @Test
    public void test() {
        stringRedisTemplate.opsForValue().set("key1", "1");
        Assert.assertEquals("1", stringRedisTemplate.opsForValue().get("key1"));
    }

    @Test
    public void testRedisTemplate() {
        User u = new User("zong", 30);
        userRedisTemplate.opsForValue().set("zong", u);
        System.out.println(userRedisTemplate.opsForValue().get("zong"));

        User user = new User("超人", 20);
        userRedisTemplate.opsForValue().set(user.getUsername(), user);
        user = new User("蝙蝠侠", 30);
        userRedisTemplate.opsForValue().set(user.getUsername(), user);
        user = new User("蜘蛛侠", 40);
        userRedisTemplate.opsForValue().set(user.getUsername(), user);
        Assert.assertEquals(20, userRedisTemplate.opsForValue().get("超人").getAge().longValue());
        Assert.assertEquals(30, userRedisTemplate.opsForValue().get("蝙蝠侠").getAge().longValue());
        Assert.assertEquals(40, userRedisTemplate.opsForValue().get("蜘蛛侠").getAge().longValue());

        Person p = new Person("mo", 1);
        personRedisTemplate.opsForValue().set("mo", p);
        System.out.println(userRedisTemplate.opsForValue().get("mo"));
    }

    /**
     * 自增时不用判断key是否存在
     */
    @Test
    public void incr() {
        integerRedisTemplate.opsForValue().increment("intKey", 1);
        integerRedisTemplate.expire("intKey", 1, TimeUnit.MINUTES);
    }

    /**
     * 获取所有key和value
     */
    @Test
    public void keyvalue1() {
        for (int i = 0; i < 10; i++) {
            integerRedisTemplate.opsForValue().set("i" + i, i, i + 1, TimeUnit.MINUTES);
        }
        // 获取所有key和value
        Map<String, Integer> map = new HashMap<>();
        final Set<String> keys = integerRedisTemplate.keys("*");
        for (String key : keys) {
            final Integer value = integerRedisTemplate.opsForValue().get(key);
            map.put(key, value);
        }
        System.out.println(map);


    }

    /**
     * 获取所有key和value
     * 生产环境可能会禁用keys，当keys不能使用时，可使用该方法
     */
    @Test
    public void keyvalue2() {
        Map<String, Integer> map = new HashMap<>();
        final Cursor<String> scan = scan(integerRedisTemplate, "*", 1000);
        while (scan.hasNext()) {
            final String key = scan.next();
            final Integer value = integerRedisTemplate.opsForValue().get(key);
            map.put(key, value);
        }
        System.out.println(map);
    }

    private static Cursor<String> scan(RedisTemplate redisTemplate, String match, int count) {
        ScanOptions scanOptions = ScanOptions.scanOptions().match(match).count(count).build();
        RedisSerializer<String> redisSerializer = (RedisSerializer<String>) redisTemplate.getKeySerializer();
        return (Cursor) redisTemplate.executeWithStickyConnection(redisConnection ->
                new ConvertingCursor<>(redisConnection.scan(scanOptions), redisSerializer::deserialize));
    }

}
