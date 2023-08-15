package com.example.spring.beans;

import org.junit.Test;
import org.springframework.util.StopWatch;

public class StopWatchTest {

    @Test
    public void getTotalTimeMillis() throws InterruptedException {
        StopWatch sw = new StopWatch();
        sw.start();
        //long task simulation
        Thread.sleep(1000);
        sw.stop();
        System.out.println(sw.getTotalTimeMillis());
    }

    @Test
    public void getLastTaskTimeMillis() throws InterruptedException {
        StopWatch sw = new StopWatch();
        sw.start("A");//setting a task name
        //long task simulation
        Thread.sleep(1000);
        sw.stop();
        System.out.println(sw.getLastTaskTimeMillis());
    }

    @Test
    public void prettyPrint() throws InterruptedException {
        StopWatch sw = new StopWatch();
        sw.start("A");
        Thread.sleep(500);
        sw.stop();
        sw.start("B");
        Thread.sleep(300);
        sw.stop();
        sw.start("C");
        Thread.sleep(200);
        sw.stop();
        System.out.println(sw.prettyPrint());
        System.out.println(sw.shortSummary());
        System.out.println(sw.getTaskCount());
        System.out.println(sw.getLastTaskInfo().getTaskName());
    }
}
