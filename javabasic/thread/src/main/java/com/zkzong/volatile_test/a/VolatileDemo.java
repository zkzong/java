package com.zkzong.volatile_test.a;

import java.util.concurrent.TimeUnit;

class MyData {
    int number = 0;

    //volatile int number = 0;
    public void setTo60() {
        this.number = 60;
    }
}

/**
 * 可见性
 */
public class VolatileDemo {
    public static void main(String[] args) {
        volatileVisibilityDemo();
    }

    //volatile可以保证可⻅性，及时通知其它线程主物理内存的值已被修改
    private static void volatileVisibilityDemo() {
        System.out.println("可⻅性测试");
        MyData myData = new MyData();//资源类
        //启动⼀个线程操作共享数据
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t 执⾏");
            try {
                TimeUnit.SECONDS.sleep(3);
                myData.setTo60();
                System.out.println(Thread.currentThread().getName() + "\t更新number值: " + myData.number);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "ThreadA").start();
        while (myData.number == 0) {
            //main线程持有共享数据的拷⻉，⼀直为0
        }
        System.out.println(Thread.currentThread().getName() + "\t main获取number值: " + myData.number);
    }
}
