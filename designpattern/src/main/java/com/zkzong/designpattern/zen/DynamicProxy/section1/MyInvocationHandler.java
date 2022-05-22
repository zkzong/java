package com.zkzong.designpattern.zen.DynamicProxy.section1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by Zong on 2016/11/9.
 * 动态代理的Handler类
 */
public class MyInvocationHandler implements InvocationHandler {
    // 被代理的对象
    private Object target = null;

    // 通过构造函数传递一个对象
    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    // 代理方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 执行被代理的方法
        return method.invoke(this.target, args);
    }
}
