package org.example;

import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureTest {

    @Test
    public void a() throws ExecutionException, InterruptedException {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();
        completableFuture.complete("三友");
        System.out.println(completableFuture.get());


        //CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> "三友");
        //System.out.println(completableFuture.get());
    }
}
