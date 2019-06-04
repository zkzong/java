package com.zkzong.java.util.concurrent.countdownlatch.wait;

/**
 * @author zkzong
 * @date 2017/10/16
 */
public class MyThread extends Thread {
    private MyService service;

    public MyThread(MyService service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.testMethod();
    }
}
