package org.example.thread.threadpool.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class Run1 implements Runnable {

    private CountDownLatch countDownLatch;

    public Run1(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            System.out.println("1");
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            countDownLatch.countDown();
        }
    }
}
