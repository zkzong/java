package com.example.java.util.concurrent.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class MyTest {

    public static void main(String[] args) {
        CountDownLatch start = new CountDownLatch(1);// 初始化计数器为 一
        for (int i = 0; i < 16; i++) {//模拟16个线程
            MyTestThread tt = new MyTestThread(start);
            Thread t = new Thread(tt);
            t.start();
        }
        System.out.println("先打印本输出语句，然后才会执行多线程");
        start.countDown();//计数器減一  所有线程释放 同时跑
    }
}
