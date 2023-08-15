package com.example.java.util.concurrent.cyclicbarrier.run4;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author zkzong
 * @date 2017/10/19
 */
public class MyService {
    public CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new Runnable() {
        @Override
        public void run() {
            System.out.println(" 彻底结束了 " + System.currentTimeMillis());
        }
    });

    private void testMethod() {
        try {
            System.out.println(Thread.currentThread().getName() + " 准备！" + System.currentTimeMillis());
            if ("C".equals(Thread.currentThread().getName())) {
                Thread.sleep(Integer.MAX_VALUE);
            }
            cyclicBarrier.await();
            System.out.println(Thread.currentThread().getName() + " 开始！" + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

}
