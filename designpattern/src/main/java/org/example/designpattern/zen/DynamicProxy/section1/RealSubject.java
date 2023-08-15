package com.example.designpattern.zen.DynamicProxy.section1;

/**
 * Created by Zong on 2016/11/9.
 * 真实主题
 */
public class RealSubject implements Subject {

    @Override
    public void doSomething(String str) {
        System.out.println("do something!---->" + str);
    }
}
