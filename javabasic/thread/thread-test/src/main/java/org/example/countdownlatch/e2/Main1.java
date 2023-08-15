package com.example.countdownlatch.e2;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main1 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        long begin = System.currentTimeMillis();
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<String> future = executorService.submit(new Task001("张三"));
        Future<String> future2 = executorService.submit(new Task002("李四"));
        executorService.shutdown();
        System.out.println("*-------------");
        while (!executorService.isTerminated()) {
            Thread.sleep(100);
        }
        System.out.println("执行完善结果：" + future.get() + ":" + future2.get() + " 总用时：" + ((System.currentTimeMillis() - begin) / 1000) + "秒");
    }
}
