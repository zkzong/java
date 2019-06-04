package com.zkzong.java.util.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Zong on 2016/12/10.
 */
public class Waiter implements Runnable {
    CountDownLatch latch = null;

    public Waiter(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            latch.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Waiter Released");
    }
}
