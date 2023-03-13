package org.example.threadlocal.test;

public class InheriableThreadLocalTest {

    static ThreadLocal<Integer> threadLocal = new InheritableThreadLocal<>();

    public static void main(String[] args) {
        threadLocal.set(1000);
        new Thread(() -> {
            System.out.println(Thread.currentThread() + "===" + threadLocal.get());
        }).start();
    }

}
