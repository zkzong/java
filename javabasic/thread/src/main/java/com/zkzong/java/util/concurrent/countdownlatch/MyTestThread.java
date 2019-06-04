package com.zkzong.java.util.concurrent.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class MyTestThread implements Runnable {
    private final CountDownLatch startSignal;

    public MyTestThread(CountDownLatch startSignal) {
        super();
        this.startSignal = startSignal;
    }

    @Override
    public void run() {
        try {
            startSignal.await(); //一直阻塞当前线程，直到计时器的值为0
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        doWork();

    }

    private void doWork() {
        System.out.println("do work");
    }

}
