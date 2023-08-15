package com.example.countdownlatch.e2;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

public class Task002 implements Callable<String> {

    private String name;
    private CountDownLatch countDown;

    public Task002(String name) {
        this.name = name;
    }

    public Task002(String name, CountDownLatch countDown) {
        this(name);
        this.countDown = countDown;
    }

    @Override
    public String call() throws Exception {
        long begin = System.currentTimeMillis();
        System.out.println(name + " 第二个分任务开始....");
        Thread.sleep(5000);
        System.out.println(name + " 第二个分任务结束....");
        System.out.println("任务二 用时：" + ((System.currentTimeMillis() - begin) / 1000) + "秒");
        if (this.countDown != null) {
            this.countDown.countDown();
        }
        return "成功二";
    }

}
