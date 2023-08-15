package com.example.lettuce;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.ConvertingCursor;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Set;

/**
 * 获取key的两种方式
 *
 * @Author: zong
 * @Date: 2021/12/28
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisKeyTest {

    @Resource
    private RedisTemplate<String, String> redisTemplate;

    /**
     * 使用keys获取所有key
     */
    @Test
    public void iter1() {
        Set<String> keys = redisTemplate.keys("*");
        for (String key : keys) {
            System.out.println(key);
        }
    }

    /**
     * 使用scan获取所有key，需要指定获取个数，每次获取指定个数的key，循环获取
     * 生产环境可能会禁用keys，当keys不能使用时，可使用该方法
     */
    @Test
    public void iter2() {
        Cursor<String> scan = scan(redisTemplate, "*", 1000);
        while (scan.hasNext()) {
            String key = scan.next();
            System.out.println(key);
        }
    }

    private Cursor<String> scan(RedisTemplate redisTemplate, String match, int count) {
        ScanOptions scanOptions = ScanOptions.scanOptions().match(match).count(count).build();
        RedisSerializer<String> redisSerializer = (RedisSerializer<String>) redisTemplate.getKeySerializer();
        return (Cursor) redisTemplate.executeWithStickyConnection(redisConnection ->
                new ConvertingCursor<>(redisConnection.scan(scanOptions), redisSerializer::deserialize));
    }
}
