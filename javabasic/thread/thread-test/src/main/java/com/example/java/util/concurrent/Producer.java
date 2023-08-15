package com.example.java.util.concurrent;

import java.util.concurrent.BlockingQueue;

/**
 * Created by Zong on 2016/12/9.
 */
public class Producer implements Runnable {
    protected BlockingQueue queue = null;

    public Producer(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            queue.put(1);
            Thread.sleep(1000);
            queue.put(2);
            Thread.sleep(1000);
            queue.put(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
