package org.example.proxy.dynamicproxy;

/**
 * Created by Zong on 2016/7/20.
 */
public class RealSubject implements Subject {
    @Override
    public void rent() {
        System.out.println("I want to rent my house");
    }

    @Override
    public void hello(String str) {
        System.out.println("hello: " + str);
    }
}
