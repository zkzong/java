package com.example.sb.sentinel.service;

import com.example.sb.sentinel.vo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @Author: Zong
 * @Date: 2018/10/22
 */
@Service("redisService")
public class RedisService {
    @Autowired //操作字符串的template，StringRedisTemplate是RedisTemplate的一个子集
    private StringRedisTemplate stringRedisTemplate;

    @Autowired  // RedisTemplate，可以进行所有的操作
    private RedisTemplate<Object, Object> redisTemplate;

    public void set(String key, String value) {
        stringRedisTemplate.opsForValue().set(key, value);
    }

    public void set(Student s) {
        redisTemplate.opsForValue().set(s.getId(), s);
    }

    public String get(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }

    public Student getStudent(String key) {
        return (Student) redisTemplate.opsForValue().get(key);
    }
}

