package com.zkzong.springredis.case1.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

/**
 * Created by zong on 2017/3/2.
 */
public abstract class AbstractBaseRedisDao<K, V> {
    @Autowired
    protected RedisTemplate<K, V> redisTemplate;

//    public void setRedisTemplate(RedisTemplate<K, V> redisTemplate) {
//        this.redisTemplate = redisTemplate;
//    }

    public RedisSerializer<String> getRedisSerializer() {
        return redisTemplate.getStringSerializer();
    }
}
