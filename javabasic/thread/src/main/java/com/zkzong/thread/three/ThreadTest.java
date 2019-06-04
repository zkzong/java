package com.zkzong.thread.three;

/**
 * Created by Zong on 2016/12/5.
 */
public class ThreadTest extends Thread {
    @Override
    public void run() {
        System.out.println("继承Thread类");
    }

    public static void main(String[] args) {
        ThreadTest tt = new ThreadTest();
        tt.start();
    }
}
