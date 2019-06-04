package com.zkzong.thread.three;

/**
 * Created by Zong on 2016/12/5.
 */
public class RunnableTest implements Runnable {
    @Override
    public void run() {
        System.out.println("实现Runnable接口");
    }

    public static void main(String[] args) {
        Thread t = new Thread(new RunnableTest());
        t.start();
    }
}
