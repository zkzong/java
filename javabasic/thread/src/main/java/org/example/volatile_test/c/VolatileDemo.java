package org.example.volatile_test.c;

import java.util.concurrent.atomic.AtomicInteger;

class MyData {
    //int number=0;
    volatile int number = 0;
    AtomicInteger atomicInteger = new AtomicInteger();

    public void setTo60() {
        this.number = 60;
    }

    //此时number前⾯已经加了volatile，但是不保证原⼦性
    public void addPlusPlus() {
        number++;
    }

    public void addAtomic() {
        atomicInteger.getAndIncrement();
    }
}

/**
 * AtomicInteger 可以保证原⼦性
 */
public class VolatileDemo {
    public static void main(String[] args) {
        //volatileVisibilityDemo();
        atomicDemo();
    }

    private static void atomicDemo() {
        System.out.println("原⼦性测试");
        MyData myData = new MyData();
        for (int i = 1; i <= 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    myData.addPlusPlus();
                    myData.addAtomic();
                }
            }, String.valueOf(i)).start();
        }
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName() + "\t int类型最终number值: " + myData.number);
        System.out.println(Thread.currentThread().getName() + "\t AtomicInteger类型最终number值: " + myData.atomicInteger);
    }
}
