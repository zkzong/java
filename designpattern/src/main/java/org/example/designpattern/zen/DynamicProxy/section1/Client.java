package com.example.designpattern.zen.DynamicProxy.section1;

import java.lang.reflect.InvocationHandler;

/**
 * Created by Zong on 2016/11/9.
 */
public class Client {
    public static void main(String[] args) {
        // 定义一个主题
        Subject subject = new RealSubject();
        // 定义一个Handler
        InvocationHandler handler = new MyInvocationHandler(subject);
        // 定义主题的代理
        Subject proxy = DynamicProxy.newProxyInstance(subject.getClass().getClassLoader(),
                subject.getClass().getInterfaces(), handler);
        // 代理的行为
        proxy.doSomething("Finish");
    }
}
