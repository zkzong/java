package org.example.future;

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
    public void a() throws ExecutionException, InterruptedException {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();
        completableFuture.complete("三友");
        System.out.println(completableFuture.get());


        //CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> "三友");
        //System.out.println(completableFuture.get());
    }
}
