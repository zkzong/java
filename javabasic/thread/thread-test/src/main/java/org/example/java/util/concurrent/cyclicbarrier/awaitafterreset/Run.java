package org.example.java.util.concurrent.cyclicbarrier.awaitafterreset;

import java.util.concurrent.CyclicBarrier;

/**
 * @author zkzong
 * @date 2017/10/19
 */
public class Run {
    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);

        ThreadA threadA1 = new ThreadA(cyclicBarrier);
        threadA1.start();
        Thread.sleep(500);
        System.out.println(cyclicBarrier.getNumberWaiting());

        ThreadA threadA2 = new ThreadA(cyclicBarrier);
        threadA2.start();
        Thread.sleep(500);
        System.out.println(cyclicBarrier.getNumberWaiting());

        ThreadA threadA3 = new ThreadA(cyclicBarrier);
        threadA3.start();
        Thread.sleep(500);
        System.out.println(cyclicBarrier.getNumberWaiting());

        ThreadA threadA4 = new ThreadA(cyclicBarrier);
        threadA4.start();
        Thread.sleep(500);
        System.out.println(cyclicBarrier.getNumberWaiting());
    }
}
