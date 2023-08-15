package com.example.thread.synchronizedpackage;

/**
 * Created by zong on 16-10-7.
 * 修饰一个类
 */
public class SyncThread2 implements Runnable {
    private static int count;

    public SyncThread2() {
        count = 0;
    }

    public int getCount() {
        return count;
    }

    public static void method() {
        synchronized (SyncThread2.class) {
            for (int i = 0; i < 5; i++) {
                try {
                    System.out.println(Thread.currentThread().getName() + ":" + (count++));
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public synchronized void run() {
        method();
    }

    public static void main(String[] args) {
        SyncThread2 syncThread1 = new SyncThread2();
        SyncThread2 syncThread2 = new SyncThread2();
        Thread thread1 = new Thread(syncThread1, "SyncThread1");
        Thread thread2 = new Thread(syncThread2, "SyncThread2");
        thread1.start();
        thread2.start();
    }
}
