package com.zkzong.countdownlatch.e2;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main2 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        CountDownLatch countDown = new CountDownLatch(2);
        long begin = System.currentTimeMillis();
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<String> future = executorService.submit(new Task001("张三", countDown));
        Future<String> future2 = executorService.submit(new Task002("李四", countDown));
        executorService.shutdown();
        System.out.println("*-------------");
        countDown.await();
        System.out.println("执行完善结果：" + future.get() + ":" + future2.get() + " 总用时：" + ((System.currentTimeMillis() - begin) / 1000) + "秒");
    }
}
