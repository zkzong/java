package com.zkzong.volatile_test.b;

class MyData {
    //int number=0;
    volatile int number = 0;

    //此时number前⾯已经加了volatile，但是不保证原⼦性
    public void addPlusPlus() {
        number++;
    }
}

/**
 * 原子性
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
                }
            }, String.valueOf(i)).start();
        }
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName() + "\t int类型最终number值: " + myData.number);
    }
}
