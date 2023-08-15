package com.example.thread.join;

/**
 * Created by Zong on 2016/11/18.
 */
class ThreadTesterA implements Runnable {

    private int counter;

    @Override
    public void run() {
        System.out.println("A开始" + System.currentTimeMillis());
        while (counter <= 10) {
            System.out.println("Counter = " + counter + " ");
            counter++;
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("A结束" + System.currentTimeMillis());
        System.out.println();
    }
}

class ThreadTesterB implements Runnable {

    private int i;

    @Override
    public void run() {
        System.out.println("B开始" + System.currentTimeMillis());
        while (i <= 10) {
            System.out.println("i = " + i + " ");
            i++;
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("B结束" + System.currentTimeMillis());
        System.out.println();
    }
}

public class Join {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new ThreadTesterA());
        Thread t2 = new Thread(new ThreadTesterB());
        t1.start();
        t1.join();
        t2.start();
        t2.join();
    }
}
