package org.example.thread.synchronizedpackage;

/**
 * Created by zong on 16-10-7.
 * 修饰一个静态的方法
 */
public class SyncThread1 implements Runnable {
    private static int count;

    public SyncThread1() {
        count = 0;
    }

    public int getCount() {
        return count;
    }

    public synchronized static void method() {
        for (int i = 0; i < 5; i++) {
            try {
                System.out.println(Thread.currentThread().getName() + ":" + (count++));
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public synchronized void run() {
        method();
    }

    public static void main(String[] args) {
        SyncThread1 syncThread1 = new SyncThread1();
        SyncThread1 syncThread2 = new SyncThread1();
        Thread thread1 = new Thread(syncThread1, "SyncThread1");
        Thread thread2 = new Thread(syncThread2, "SyncThread2");
        thread1.start();
        thread2.start();
    }
}
