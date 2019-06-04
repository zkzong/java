package com.zkzong.java.util.concurrent.countdownlatch.test3;

import java.util.concurrent.CountDownLatch;

/**
 * @author zkzong
 * @date 2017/10/16
 */
public class MyThread extends Thread {
    private CountDownLatch maxRunner;

    public MyThread(CountDownLatch maxRunner) {
        this.maxRunner = maxRunner;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
            maxRunner.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
