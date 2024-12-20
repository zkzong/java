package com.example.future;

import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CompletableFutureTest {

    @Test
    public void threadstate() throws InterruptedException {
        Thread thread = new Thread();
        System.out.println("1- " + thread.getState());
        thread.start();
        System.out.println("2- " + thread.getState());
        TimeUnit.SECONDS.sleep(1);
        System.out.println("3- " + thread.getState());
    }

    @Test
    public void complete() throws ExecutionException, InterruptedException {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();
        completableFuture.complete("三友");
        System.out.println(completableFuture.get());


        //CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> "三友");
        //System.out.println(completableFuture.get());
    }

    @Test
    public void anyOf() {
        // 创建两个CompletableFuture任务
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000); // 模拟任务执行时间
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return "Task 1 completed";
        });

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000); // 模拟任务执行时间
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return "Task 2 completed";
        });

        // 使用anyOf方法，当任意一个任务完成时，新的CompletableFuture也会完成
        CompletableFuture<Object> anyOfFuture = CompletableFuture.anyOf(future1, future2);

        try {
            // 等待任意一个任务完成
            Object result = anyOfFuture.get();
            System.out.println("First completed task result: " + result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
