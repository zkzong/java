package com.example.thread.synchronizedpackage;

/**
 * 一个对象有一把锁！多个线程多个锁！
 *
 * @Author: zong
 * @Date: 2019-07-24
 */
public class MultiThread {

    private int num = 200;

    public synchronized void printNum(String threadName, String tag) {
        if (tag.equals("a")) {
            num = num - 100;
            System.out.println(threadName + " tag a,set num over!");
        } else {
            num = num - 200;
            System.out.println(threadName + " tag b,set num over!");
        }
        System.out.println(threadName + " tag " + tag + ", num = " + num);
    }

    public static void main(String[] args) throws InterruptedException {
        final MultiThread multiThread1 = new MultiThread();
        final MultiThread multiThread2 = new MultiThread();

        new Thread(new Runnable() {
            @Override
            public void run() {
                multiThread1.printNum("thread1", "a");
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                multiThread2.printNum("thread2", "b");
            }
        }).start();
    }

    // 输出：
    //thread1 tag a,set num over!
    //thread1 tag a, num = 100
    //thread2 tag b,set num over!
    //thread2 tag b, num = 0
}
