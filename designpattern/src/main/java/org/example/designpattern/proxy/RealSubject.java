package com.example.designpattern.proxy;


/**
 * Created by zong on 2016/8/9.
 * 实际对象
 */
public class RealSubject implements Subject {
    @Override
    public String sayHello(String name) {
        return "hello " + name;
    }

    @Override
    public String sayGoodBye() {
        return "good bye";
    }
}
