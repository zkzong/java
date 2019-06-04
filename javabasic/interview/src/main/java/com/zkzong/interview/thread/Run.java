package com.zkzong.interview.thread;

/**
 * Created by Zong on 2016/12/6.
 */
public class Run implements Runnable {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Run());
        Thread t2 = new Thread(new Run());
        t1.start();
        t2.run();
        System.out.println(Thread.currentThread().getName() + " end");
        /*
        main start
        main end
        Thread-0 start
         */
    }

    @Override
    public void run() {
        print();
    }

    private void print() {
        System.out.println(Thread.currentThread().getName() + " start");
    }
}
