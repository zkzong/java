package com.example.designpattern.zen.DynamicProxy.section1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by Zong on 2016/11/9.
 * 动态代理类
 */
public class DynamicProxy<T> {
    public static <T> T newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler h) {
        // 寻找JoinPoint连接点，AOP框架使用元数据定义
        if (true) {
            // 执行一个前置通知
            (new BeforeAdvice()).exec();
        }
        // 执行目标，并返回结果
        return (T) Proxy.newProxyInstance(loader, interfaces, h);
    }
}
