package org.example.concurrent;

import org.junit.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * @Author: zkzong
 * @Date: 2019/10/26
 */
public class QueueTest {

    // ArrayBlockingQueue
    @Test
    public void t1() {
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(5);
        queue.add("1");
        // 插入null报错
        queue.add(null);
        System.out.println(queue);
    }

    // LinkedBlockingQueue
    @Test
    public void t2() {
        BlockingQueue<String> queue = new LinkedBlockingQueue<>();
        queue.add("1");
        // 插入null报错
        queue.add(null);
        System.out.println(queue);
    }

    // PriorityBlockingQueue
    @Test
    public void t3() {
        BlockingQueue<String> queue = new PriorityBlockingQueue<>(5);
        queue.add("1");
        // 插入null报错
        queue.add(null);
        System.out.println(queue);
    }

    // SynchronousQueue
    @Test
    public void t4() {
        BlockingQueue<String> queue = new SynchronousQueue<String>();
        // 只能插入一个元素
        queue.add("1");
        System.out.println(queue);
    }
}
