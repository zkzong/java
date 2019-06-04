package com.zkzong;

import java.util.concurrent.CountDownLatch;

public class TestHarness {
    public static void main(String[] args) throws InterruptedException {
        TestHarness testHarness = new TestHarness();
        long timeTasks = testHarness.timeTasks(10, new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        System.out.println(timeTasks);
    }

    public long timeTasks(int nThreads, final Runnable task) throws InterruptedException {
        //预热，编译
        for (int i = 0; i < 10000; i++) {
            task.run();
        }
        // 真正的测试
        // 使用同步工具类，保证多个线程同时（近似同时）执行
        final CountDownLatch startGate = new CountDownLatch(1);
        // 使用同步工具类，用于等待所有线程都运行结束时，再统计耗时
        final CountDownLatch endGate = new CountDownLatch(nThreads);
        for (int i = 0; i < nThreads; i++) {
            Thread t = new Thread() {
                @Override
                public void run() {
                    try {
                        startGate.await();
                        try {
                            task.run();
                        } finally {
                            endGate.countDown();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            t.start();
        }
        long start = System.currentTimeMillis();
        startGate.countDown();
        endGate.await();
        long end = System.currentTimeMillis();
        return end - start;
    }
}
