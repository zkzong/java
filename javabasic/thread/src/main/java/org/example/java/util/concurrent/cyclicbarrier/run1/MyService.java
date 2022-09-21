package org.example.java.util.concurrent.cyclicbarrier.run1;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author zkzong
 * @date 2017/10/19
 */
public class MyService {
    private CyclicBarrier cyclicBarrier;

    public MyService(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    public void beginRun() {
        try {
            long sleepValue = (int) (Math.random() * 10000);
            Thread.sleep(sleepValue);
            System.out.println(Thread.currentThread().getName() + " " + System.currentTimeMillis()
                    + " begin跑第1阶段" + (cyclicBarrier.getNumberWaiting() + 1));
            cyclicBarrier.await();
            System.out.println(Thread.currentThread().getName() + " " + System.currentTimeMillis()
                    + " end跑第1阶段" + (cyclicBarrier.getNumberWaiting() + 1));

            sleepValue = (int) (Math.random() * 10000);
            Thread.sleep(sleepValue);
            System.out.println(Thread.currentThread().getName() + " " + System.currentTimeMillis()
                    + " begin跑第2阶段" + (cyclicBarrier.getNumberWaiting() + 1));
            cyclicBarrier.await();
            System.out.println(Thread.currentThread().getName() + " " + System.currentTimeMillis()
                    + " end跑第2阶段" + (cyclicBarrier.getNumberWaiting() + 1));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
