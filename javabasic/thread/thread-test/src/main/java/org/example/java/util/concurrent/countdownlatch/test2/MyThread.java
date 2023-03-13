package org.example.java.util.concurrent.countdownlatch.test2;

/**
 * @author zkzong
 * @date 2017/10/16
 */
public class MyThread extends Thread {
    private MyService myService;

    public MyThread(MyService myService) {
        this.myService = myService;
    }

    @Override
    public void run() {
        myService.testMethod();
    }
}
