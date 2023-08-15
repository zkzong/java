package com.example.java.util.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Zong on 2016/12/10.
 */
public class Decrementer implements Runnable {
    CountDownLatch latch = null;

    public Decrementer(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            this.latch.countDown();

            Thread.sleep(1000);
            this.latch.countDown();

            Thread.sleep(1000);
            this.latch.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
