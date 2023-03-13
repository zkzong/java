package org.example.java.util.concurrent.cyclicbarrier.run1;

/**
 * @author zkzong
 * @date 2017/10/19
 */
public class ThreadA extends Thread {
    private MyService service;

    public ThreadA(MyService service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.beginRun();
    }
}
