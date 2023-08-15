package com.example.java.util.concurrent.countdownlatch.test2;

import java.util.concurrent.CountDownLatch;

/**
 * @author zkzong
 * @date 2017/10/16
 */
public class MyService {
    private CountDownLatch down = new CountDownLatch(1);

    public void testMethod() {
        try {
            System.out.println(Thread.currentThread().getName() + "准备");
            down.await();
            System.out.println(Thread.currentThread().getName() + "结束");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void downMethod() {
        System.out.println("开始");
        down.countDown();
    }
}
