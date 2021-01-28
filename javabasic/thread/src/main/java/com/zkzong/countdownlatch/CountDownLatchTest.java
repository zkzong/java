package com.zkzong.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest extends Thread {

    // todo
    static CountDownLatch c1 = new CountDownLatch(1);
    static CountDownLatch c2 = new CountDownLatch(1);
    static CountDownLatch c3 = new CountDownLatch(1);

    public static void main(String[] args) throws InterruptedException {
        System.out.println("start");
        new Thread(new Runnable() {
            @Override
            public void run() {
                // todo
                try {
                    c1.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                c2.countDown();
                System.out.println("step2");
            }
        }).start();
        // todo
        c1.countDown();
        System.out.println("step1");
        new Thread(new Runnable() {
            @Override
            public void run() {
                // todo
                try {
                    c2.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                c3.countDown();
                System.out.println("step3");
            }
        }).start();
        // todo
        c3.await();
        System.out.println("end");
    }
}
