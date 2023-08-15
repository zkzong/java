package com.example.java.util.concurrent.countdownlatch.test1;

import java.util.concurrent.CountDownLatch;

/**
 * @author zkzong
 * @date 2017/10/16
 */
public class MyService {
    private CountDownLatch down = new CountDownLatch(1);

    public void testMethod() {
        try {
            System.out.println("A");
            down.await();
            System.out.println("B");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void downMethod() {
        System.out.println("X");
        down.countDown();
    }
}
