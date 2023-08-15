package com.example.java.util.concurrent.cyclicbarrier.run2;

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

    private void beginRun(int count) {
        try {
            System.out.println(Thread.currentThread().getName() + " 到了 在等待其他人都到了开始起跑");
            if ("Thread-2".equals(Thread.currentThread().getName())) {
                System.out.println("thread-2进来了");
                Thread.sleep(5000);
//                Integer.parseInt("a");
                Thread.currentThread().interrupt();
            }
            cyclicBarrier.await();
            System.out.println("都到了，开始跑");
            System.out.println(Thread.currentThread().getName() + " 到达终点，并结束第" + count + "赛段");
        } catch (InterruptedException e) {
            System.out.println("进入了InterruptedException e " + cyclicBarrier.isBroken());
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            System.out.println("进入了BrokenBarrierException e " + cyclicBarrier.isBroken());
            e.printStackTrace();
        }
    }

    public void testA() {
        // 比赛1个赛段
        for (int i = 0; i < 1; i++) {
            beginRun(i + 1);
        }
    }
}
