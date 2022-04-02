package com.zkzong.jvm;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 内存泄漏
 * -Xms20m -Xmx20m -XX:+PrintGC -XX:+HeapDumpOnOutOfMemoryError  -XX:HeapDumpPath=heap.bin
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        while (true) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            main.run();
        }
    }

    private void run() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            executorService.execute(() -> {
                // do something...
            });
        }
    }
}
