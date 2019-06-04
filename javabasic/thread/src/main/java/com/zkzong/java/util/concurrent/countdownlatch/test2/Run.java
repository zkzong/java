package com.zkzong.java.util.concurrent.countdownlatch.test2;

/**
 * @author zkzong
 * @date 2017/10/16
 */
public class Run {
    public static void main(String[] args) throws InterruptedException {
        MyService service = new MyService();
        MyThread[] tArray = new MyThread[10];
        for (int i = 0; i < tArray.length; i++) {
            tArray[i] = new MyThread(service);
            tArray[i].setName(" 线程 " + (i + 1));
            tArray[i].start();
        }
        Thread.sleep(2000);
        service.downMethod();
    }
}
