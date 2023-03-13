package org.example.java.util.concurrent.countdownlatch.test3;

import java.util.concurrent.CountDownLatch;

/**
 * @author zkzong
 * @date 2017/10/16
 */
public class Run {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch maxRunner = new CountDownLatch(10);
        MyThread[] tArray = new MyThread[Integer.parseInt("" + maxRunner.getCount())];
        for (int i = 0; i < tArray.length; i++) {
            tArray[i] = new MyThread(maxRunner);
            tArray[i].setName(" 线程 " + (i + 1));
            tArray[i].start();
        }
        maxRunner.await();
        System.out.println("都回来了！");
    }
}
