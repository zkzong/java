package com.zkzong.threadlocal;

public class InheriableThreadLocalTest {
    public static final InheritableThreadLocal<?> itl = new InheritableThreadLocal<Object>() {
        @Override
        protected Object initialValue() {
            return System.currentTimeMillis();
        }

        @Override
        protected Object childValue(Object parentValue) {
            return parentValue + " which plus in subThread.";
        }
    };

    public static void main(String[] args) {
        System.out.println("Main: get value = " + itl.get());
        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + ": get value = " + itl.get());
            }
        });
        a.start();
    }
}
