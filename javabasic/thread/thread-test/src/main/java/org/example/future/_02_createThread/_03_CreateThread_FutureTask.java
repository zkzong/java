package org.example.future._02_createThread;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class _03_CreateThread_FutureTask {
    public static void main(String[] args) {
        Callable<String> callable = () -> {
            System.out.println("我是子任务");
            return "sub task done";
        };
        FutureTask<String> task = new FutureTask(callable);
        Thread thread = new Thread(task);
        thread.start();
        System.out.println("子线程启动");
        try {
            String subResult = task.get(5, TimeUnit.MINUTES);
            System.out.println("子线程返回值：" + subResult);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            Throwable cause = e.getCause();
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        System.out.println("main 结束");
    }
}
