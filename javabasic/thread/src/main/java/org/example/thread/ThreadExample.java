package org.example.thread;

import org.junit.Test;

/**
 * Created by Zong on 2016/7/28.
 */
public class ThreadExample {
    @Test
    public void main() {
        System.out.println(Thread.currentThread().getName());
        for (int i = 0; i < 10; i++) {
            new Thread("" + i) {
                @Override
                public void run() {
                    System.out.println("Thread: " + getName() + " running");
                }
            }.start();
        }
    }

    /**
     * 只是new Exception对象不会抛出异常
     */
    @Test
    public void nothrow() {
        for (int i = 0; i < 500; i++) {
            final int j = i;
            //System.out.println(j);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    new RuntimeException(j + "");
                    System.out.println(j);
                }
            }).start();
        }
    }

    /**
     * throw Exception
     */
    @Test
    public void throwexception() {
        new Thread() {
            @Override
            public void run() {
                try {
                    throw new Exception();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
