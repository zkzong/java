package com.example.java.util.concurrent.cyclicbarrier.threadbigparties;

import java.util.concurrent.CyclicBarrier;

/**
 * @author zkzong
 * @date 2017/10/19
 */
public class Run {
    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2, new Runnable() {
            @Override
            public void run() {
                System.out.println("全来了！");
            }
        });

        for (int i = 0; i < 4; i++) {
            ThreadA threadA = new ThreadA(cyclicBarrier);
            threadA.start();
            Thread.sleep(2000);
        }
    }
}
