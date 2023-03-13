package org.example;

import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class FutureTest {

    private FutureTask<String> futureTask;

    @Test
    public void a() throws ExecutionException, InterruptedException {
        FutureTask<String> futureTask = new FutureTask<>(() -> "三友");
        new Thread(futureTask).start();
        System.out.println(futureTask.get());
    }

    @Test
    public void b() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> future = executorService.submit(() -> "三友");
        System.out.println(future.get());
        executorService.shutdown();
    }
}
