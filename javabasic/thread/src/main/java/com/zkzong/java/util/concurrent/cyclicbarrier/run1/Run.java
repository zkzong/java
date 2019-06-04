package com.zkzong.java.util.concurrent.cyclicbarrier.run1;

import java.util.concurrent.CyclicBarrier;

/**
 * @author zkzong
 * @date 2017/10/19
 */
public class Run {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2);

        MyService service = new MyService(cyclicBarrier);

        ThreadA threadA1 = new ThreadA(service);
        threadA1.setName("A");
        threadA1.start();

        ThreadA threadA2 = new ThreadA(service);
        threadA2.setName("B");
        threadA2.start();

        ThreadA threadA3 = new ThreadA(service);
        threadA3.setName("C");
        threadA3.start();

        ThreadA threadA4 = new ThreadA(service);
        threadA4.setName("D");
        threadA4.start();
    }
}
