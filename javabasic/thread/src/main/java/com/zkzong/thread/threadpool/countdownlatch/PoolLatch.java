package com.zkzong.thread.threadpool.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池和CountDownLatch结合案例
 */
public class PoolLatch {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 10, 1000L, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>());

        CountDownLatch countDownLatch = new CountDownLatch(3);

        long start = System.currentTimeMillis();

        Run1 run1 = new Run1(countDownLatch);
        Run2 run2 = new Run2(countDownLatch);
        Run3 run3 = new Run3(countDownLatch);

        threadPoolExecutor.execute(run1);
        threadPoolExecutor.execute(run2);
        threadPoolExecutor.execute(run3);

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        System.out.println("共耗时：" + (end - start));

        System.out.println("end");

    }
}
