package com.example.redisson;

import com.example.redisson.config.RedissonTemplate;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class LockTest {

    @Autowired
    private RedissonTemplate redissonTemplate;

    private CountDownLatch count = new CountDownLatch(2);

    @Test
    public void lock() {
        String lockName = "hello-test";


        new Thread(() -> {

            String threadName = Thread.currentThread().getName();
            log.info("线程：{} 正在尝试获取锁。。。", threadName);
            boolean lock = redissonTemplate.lock(lockName, 60L);
            doSomthing(lock, lockName, threadName);

        }).start();

        new Thread(() -> {
            String threadName = Thread.currentThread().getName();
            log.info("线程：{} 正在尝试获取锁。。。", threadName);
            boolean lock = redissonTemplate.lock(lockName, 60L);
            doSomthing(lock, lockName, threadName);
        }).start();

        try {
            count.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("子线程都已执行完毕，main函数可以结束了！");

    }

    private void doSomthing(boolean lock, String lockName, String threadName) {
        if (lock) {
            log.info("线程：{}，获取到了锁", threadName);
            try {
                try {
                    TimeUnit.SECONDS.sleep(5L);
                    count.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } finally {
                redissonTemplate.unlock(lockName);
                log.info("线程：{}，释放了锁", threadName);
            }
        }
    }

}
