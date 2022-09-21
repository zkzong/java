package org.example.designpattern.singleton;

/**
 * Created by zong on 2016/8/24.
 * 懒汉式
 */
public class Singleton4Lazy {
    private static Singleton4Lazy instance;
//    private volatile static Singleton4Lazy instance;

    private Singleton4Lazy() {
    }

    // 线程不安全
    public static Singleton4Lazy getInstance() {
        if (instance == null) {
            instance = new Singleton4Lazy();
        }
        return instance;
    }

    // 线程安全
    // 不高效。因为在任何时候只能有一个线程调用 getInstance() 方法。
    // 但是同步操作只需要在第一次调用时才被需要，即第一次创建单例实例对象时。
    public static synchronized Singleton4Lazy getInstance1() {
        if (instance == null) {
            instance = new Singleton4Lazy();
        }
        return instance;
    }

    // 双重检验锁
    public static Singleton4Lazy getSingleton4Lazy() {
        if (instance == null) { // single checked
            synchronized (Singleton4Lazy.class) {
                if (instance == null) { // double checked
                    instance = new Singleton4Lazy();
                }
            }
        }
        return instance;
    }
}
