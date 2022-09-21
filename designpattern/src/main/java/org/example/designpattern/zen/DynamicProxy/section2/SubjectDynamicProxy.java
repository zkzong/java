package org.example.designpattern.zen.DynamicProxy.section2;

import org.example.designpattern.zen.DynamicProxy.section1.DynamicProxy;
import org.example.designpattern.zen.DynamicProxy.section1.MyInvocationHandler;
import org.example.designpattern.zen.DynamicProxy.section1.Subject;

import java.lang.reflect.InvocationHandler;

/**
 * Created by Zong on 2016/11/9.
 */
public class SubjectDynamicProxy extends DynamicProxy {
    public static <T> T newProxyInstance(Subject subject) {
        // 获得ClassLoader
        ClassLoader loader = subject.getClass().getClassLoader();
        // 获得接口数组
        Class<?>[] classes = subject.getClass().getInterfaces();
        // 获得handler
        InvocationHandler handler = new MyInvocationHandler(subject);
        return newProxyInstance(loader, classes, handler);
    }
}
