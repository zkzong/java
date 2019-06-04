package com.zkzong.java.util.concurrent.cyclicbarrier.run2;

/**
 * @author zkzong
 * @date 2017/10/19
 */
public class MyThread extends Thread {
    private MyService myService;

    public MyThread(MyService myService) {
        this.myService = myService;
    }

    @Override
    public void run() {
        myService.testA();
    }
}
