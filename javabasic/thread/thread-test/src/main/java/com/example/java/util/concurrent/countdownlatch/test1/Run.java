package com.example.java.util.concurrent.countdownlatch.test1;

/**
 * @author zkzong
 * @date 2017/10/16
 */
public class Run {
    public static void main(String[] args) throws InterruptedException {
        MyService service = new MyService();
        MyThread t = new MyThread(service);
        t.start();
        Thread.sleep(2000);
        service.downMethod();
    }
}
