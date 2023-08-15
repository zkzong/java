package com.example.java.util.concurrent.cyclicbarrier.begin;

import java.util.concurrent.CyclicBarrier;

/**
 * @author zkzong
 * @date 2017/10/19
 */
public class Run {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, new Runnable() {
            @Override
            public void run() {
                System.out.println("全都到了！");
            }
        });
        MyThread[] threadArray = new MyThread[5];
        for (int i = 0; i < threadArray.length; i++) {
            threadArray[i] = new MyThread(cyclicBarrier);
        }
        for (int i = 0; i < threadArray.length; i++) {
            threadArray[i].start();
        }
    }
}
