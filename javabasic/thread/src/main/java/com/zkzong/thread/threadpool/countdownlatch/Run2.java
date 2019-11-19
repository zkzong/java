package com.zkzong.thread.threadpool.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class Run2 implements Runnable {

    private CountDownLatch countDownLatch;

    public Run2(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            System.out.println("2");
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            countDownLatch.countDown();
        }
    }
}
