package com.zkzong.thread.threadpool.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class Run3 implements Runnable {

    private CountDownLatch countDownLatch;

    public Run3(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            System.out.println("3");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            countDownLatch.countDown();
        }
    }
}
