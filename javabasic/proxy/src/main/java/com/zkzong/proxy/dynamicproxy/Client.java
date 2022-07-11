package com.zkzong.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by Zong on 2016/7/21.
 */
public class Client {
    public static void main(String[] args) {
        //要代理的真实对象
        Subject realSubject = new RealSubject();

        //要代理哪个对象，就将该对象传进去，最后是通过该真实对象来调用其方法的
        InvocationHandler handler = new DynamicProxy(realSubject);

        /**
         * 通过Proxy的newProxyInstance方法来创建代理对象
         * 第一个参数 handler.getClass().getClassLoader()，这里使用handler这个类的getClassLoader对象来加载代理对象
         * 第二个参数 realSubject.getClass().getInterfaces()，这里为代理对象提供的接口是真实对象所实行的接口，表示要代理的是该真实对象，这样就能调用组接口中的方法了
         * 第三个参数 handler，这里将这个代理对象关联到了上方的InvocationHandler这个对象上
         */
        Subject subject = (Subject) Proxy.newProxyInstance(handler.getClass().getClassLoader(), realSubject.getClass().getInterfaces(), handler);

        System.out.println(subject.getClass().getName());
        subject.rent();
        subject.hello("world");
    }
}
