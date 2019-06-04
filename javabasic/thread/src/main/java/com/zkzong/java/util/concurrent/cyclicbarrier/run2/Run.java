package com.zkzong.java.util.concurrent.cyclicbarrier.run2;

import java.util.concurrent.CyclicBarrier;

/**
 * @author zkzong
 * @date 2017/10/19
 */
public class Run {
    public static void main(String[] args) {
        int parties = 4;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(parties, new Runnable() {
            @Override
            public void run() {
                System.out.println("都到了");
            }
        });

        MyService myService = new MyService(cyclicBarrier);

        MyThread[] threadArray = new MyThread[4];
        for (int i = 0; i < threadArray.length; i++) {
            threadArray[i] = new MyThread(myService);
            threadArray[i].start();
        }
    }
}
