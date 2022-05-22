package com.zkzong.designpattern.zen.singleton.section3;

/**
 * Created by Zong on 2016/10/13.
 * 单例模式通用代码
 */
public class Singleton {
    private static final Singleton singleton = new Singleton();

    // 限制产生多个对象
    private Singleton() {
    }

    // 通过该方法获得实例对象
    public static Singleton getSingleton() {
        return singleton;
    }

    // 类中其他方法，尽量是static
    public static void doSomething() {

    }
}
