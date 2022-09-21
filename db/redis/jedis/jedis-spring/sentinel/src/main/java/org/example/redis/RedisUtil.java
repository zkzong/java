package org.example.redis;

import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.concurrent.TimeUnit;

public class RedisUtil {

    private StringRedisTemplate redisTemplate;

    public RedisUtil(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public Boolean add(String key, String value) {
        Boolean rt = Boolean.FALSE;
        rt = redisTemplate.boundValueOps(key).setIfAbsent(value);
        if (rt) {
            redisTemplate.expire(key, 30L, TimeUnit.MINUTES);
        }
        return rt;
    }

    public Boolean add(String key, String value, long expire, TimeUnit timeUnit) {
        Boolean rt = Boolean.FALSE;
        rt = redisTemplate.boundValueOps(key).setIfAbsent(value);
        if (rt) {
            redisTemplate.expire(key, expire, timeUnit);
        }
        return rt;
    }

    public String get(String key) {
        return redisTemplate.boundValueOps(key).get();
    }

    public void delete(String key) {
        redisTemplate.delete(key);
    }

    public String getAndRemove(String key) {
        String rt = redisTemplate.boundValueOps(key).get();
        redisTemplate.delete(key);
        return rt;
    }

    public Boolean hasKey(String key) {
        return redisTemplate.hasKey(key);
    }

}
