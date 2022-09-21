package org.example.redisson.controller;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedissonController {

    @Autowired
    private RedissonClient redisson;

    @GetMapping("/hello")
    public String hello() {

        //1、获取一把锁，只要锁的名字一样，就是同一把锁
        RLock lock = redisson.getLock(" my-lock ");
        //2、加锁
        lock.lock();//阻塞式等待。默认加的锁都是30s时间。
        //1)、锁的自动续期，如果业务超长，运行期间自动给锁续上新的30s。不用担心业务时间长，锁自动过期被用特
        //2)、加锁的业务只要运行完成，就不会给当前锁续期，即使不手动解锁，锁默认在30s以后自动删除。
        try {
            System.out.println("加锁成功，执行业务..." + Thread.currentThread().getId());
            Thread.sleep(30000);
        } catch (Exception e) {

        } finally {
            //3、解锁将设解锁代码没有运行，redisson会不会出现死锁
            System.out.println("释放锁..." + Thread.currentThread().getId());
            lock.unlock();
        }
        return "hello";
    }
}
