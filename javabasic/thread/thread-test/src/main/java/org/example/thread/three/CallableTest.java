package com.example.thread.three;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created by Zong on 2016/12/5.
 */
public class CallableTest implements Callable {
    @Override
    public Object call() throws Exception {
        TimeUnit.SECONDS.sleep(10);
        return "实现Callable接口";
    }

    public static void main(String[] args) throws TimeoutException {
        CallableTest ct = new CallableTest();
        FutureTask<String> task = new FutureTask<String>(ct);
        Thread t = new Thread(task);
        t.start();
        try {
            //System.out.println(task.get());
            System.out.println(task.get(5, TimeUnit.SECONDS));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
