package com.zkzong.threadlocal.test;

public class ThreadLocalTest {

    static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        threadLocal.set(1000);
        new Thread(() -> {
            System.out.println(Thread.currentThread() + "===" + threadLocal.get());
        }).start();
    }

}
