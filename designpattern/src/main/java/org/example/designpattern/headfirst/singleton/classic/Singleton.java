package org.example.designpattern.headfirst.singleton.classic;

/**
 * Created by Zong on 2016/10/15.
 * 非线程安全
 */
public class Singleton {
    private static Singleton uniqueInstance;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Singleton();
        }
        return uniqueInstance;
    }
}
