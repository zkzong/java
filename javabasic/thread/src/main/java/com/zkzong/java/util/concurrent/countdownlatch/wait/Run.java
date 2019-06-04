package com.zkzong.java.util.concurrent.countdownlatch.wait;

/**
 * @author zkzong
 * @date 2017/10/16
 */
public class Run {
    public static void main(String[] args) throws InterruptedException {
        MyService service = new MyService();
        MyThread[] threadArray = new MyThread[3];
        for (int i = 0; i < threadArray.length; i++) {
            threadArray[i] = new MyThread(service);
        }
        for (int i = 0; i < threadArray.length; i++) {
            threadArray[i].start();

        }
    }
}
