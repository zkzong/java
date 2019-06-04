package com.zkzong.thread.join;

/**
 * Created by Zong on 2016/11/18.
 */
class ThreadTesterA implements Runnable {

    private int counter;

    @Override
    public void run() {
        while (counter <= 10) {
            System.out.println("Counter = " + counter + " ");
            counter++;
        }
        System.out.println();
    }
}

class ThreadTesterB implements Runnable {

    private int i;

    @Override
    public void run() {
        while (i <= 10) {
            System.out.println("i = " + i + " ");
            i++;
        }
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
