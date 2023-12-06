package com.example.redisson.controller;

import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/redisson")
@Slf4j
public class RedissonController {

    @Autowired
    private RedissonClient redisson;

    @GetMapping("/lock")
    public String lock() {

        //1、获取一把锁，只要锁的名字一样，就是同一把锁
        RLock lock = redisson.getLock("my-lock");
        //2、加锁
        lock.lock();//阻塞式等待。默认加的锁都是30s时间。
        //1)、锁的自动续期，如果业务超长，运行期间自动给锁续上新的30s。不用担心业务时间长，锁自动过期被删除
        //2)、加锁的业务只要运行完成，就不会给当前锁续期，即使不手动解锁，锁默认在30s以后自动删除。
        log.info("开始时间：{}", new Date());
        try {
            log.info("加锁成功，执行业务..." + Thread.currentThread().getId());
            Thread.sleep(60000);
        } catch (Exception e) {

        } finally {
            log.info("结束时间：{}", new Date());
            //3、解锁将设解锁代码没有运行，redisson会不会出现死锁
            log.info("释放锁..." + Thread.currentThread().getId());
            lock.unlock();
        }
        return "hello";
    }
}
