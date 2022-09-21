package org.example.java.util.concurrent.cyclicbarrier.threadbigparties;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author zkzong
 * @date 2017/10/19
 */
public class ThreadA extends Thread {
    private CyclicBarrier cyclicBarrier;

    public ThreadA(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        try {
            Thread.sleep((int) (Math.random() * 1000));
            System.out.println(Thread.currentThread().getName() + " begin = " + System.currentTimeMillis() + "等待凑齐2个继续运行");
            cyclicBarrier.await();
            System.out.println(Thread.currentThread().getName() + "   end = " + System.currentTimeMillis() + "已经凑齐2个继续运行");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
