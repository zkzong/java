package com.zkzong.proxy.dynamic;

import com.zkzong.proxy.pattern.RealSubject;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class JdkProxySubject implements InvocationHandler {
    private RealSubject realSubject;

    public JdkProxySubject(RealSubject realSubject) {
        this.realSubject = realSubject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        System.out.println("before");
        try {
            result = method.invoke(realSubject, args);
        } catch (Exception e) {
            System.out.println("ex : " + e.getMessage());
            throw e;
        } finally {
            System.out.println("after");
        }
        return result;
    }
}
