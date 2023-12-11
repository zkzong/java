package com.example.redisson.config;

import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName RedissonTemplate
 * redisson封装操作类
 */
@Configuration
@Slf4j
public class RedissonTemplate {

    @Autowired
    private final RedissonClient redissonClient;


    /**
     * 锁前缀
     */
    private final String DEFAULT_LOCK_NAME = "redis-instance";


    public RedissonTemplate(RedissonClient redissonClient) {
        this.redissonClient = redissonClient;
    }


    /**
     * 加锁（可重入），会一直等待获取锁，不会中断
     *
     * @param lockName waitTimeout  timeout
     * @return boolean
     * @author ymy
     * @date 2021/5/13 17:53
     */
    public boolean lock(String lockName, long timeout) {
        checkRedissonClient();
        RLock lock = getLock(lockName);
        try {
            if (timeout != -1) {
                // timeout:超时时间   TimeUnit.SECONDS：单位
                lock.lock(timeout, TimeUnit.SECONDS);
            } else {
                lock.lock();
            }
            log.debug(" get lock success ,lockKey:{}", lockName);
            return true;
        } catch (Exception e) {
            log.error(" get lock fail,lockKey:{}, cause:{} ",
                    lockName, e.getMessage());
            return false;
        }
    }

    /**
     * 解锁
     *
     * @param lockName
     */
    public void unlock(String lockName) {
        checkRedissonClient();
        try {
            RLock lock = getLock(lockName);
            if (lock.isLocked() && lock.isHeldByCurrentThread()) {
                lock.unlock();
                log.debug("key：{}，unlock success", lockName);
            } else {
                log.debug("key：{}，没有加锁或者不是当前线程加的锁 ", lockName);
            }
        } catch (Exception e) {
            log.error("key：{}，unlock error,reason:{}", lockName, e.getMessage());
        }
    }


    private RLock getLock(String lockName) {
        String key = DEFAULT_LOCK_NAME + lockName;
        return redissonClient.getLock(key);
    }


    private void checkRedissonClient() {
        if (null == redissonClient) {
            log.error(" redissonClient is null ,please check redis instance ! ");
            throw new RuntimeException("redissonClient is null ,please check redis instance !");
        }
        if (redissonClient.isShutdown()) {
            log.error(" Redisson instance has been shut down !!!");
            throw new RuntimeException("Redisson instance has been shut down !!!");
        }
    }
}


