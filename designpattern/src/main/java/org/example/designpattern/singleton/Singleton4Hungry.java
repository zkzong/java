package org.example.designpattern.singleton;

/**
 * Created by zong on 2016/8/25.
 * 饿汉式
 */
public class Singleton4Hungry {
    private static final Singleton4Hungry instance = new Singleton4Hungry();

    // 静态内部类
    private static class SingletonHolder {
        private static final Singleton4Hungry INSTANCE = new Singleton4Hungry();
    }

    private Singleton4Hungry() {
    }

    public static Singleton4Hungry getInstance() {
        return instance;

//        return SingletonHolder.INSTANCE; // for 静态内部类
    }
}
