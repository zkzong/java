package org.example.thread.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Zong on 2016/12/5.
 * 创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。
 */
public class NewFixedThreadPool {
    public static void main(String[] args) {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            final int index = i;
            fixedThreadPool.submit(new Runnable() {
                @Override
                public void run() {
                    //try {
                    //    System.out.println(index);
                    //    Thread.sleep(2000);
                    //} catch (InterruptedException e) {
                    //    e.printStackTrace();
                    //}
                    System.out.println("===");
                    Object obj = null;
                    try {
                        System.out.println(obj.toString());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });


            ExecutorService threadPool = Executors.newFixedThreadPool(1, r -> {
                Thread t = new Thread(r);
                t.setUncaughtExceptionHandler(
                        (t1, e) -> {
                            System.out.println(t1.getName() + "线程抛出的异常" + e);
                        });
                return t;
            });
        }
    }
}
