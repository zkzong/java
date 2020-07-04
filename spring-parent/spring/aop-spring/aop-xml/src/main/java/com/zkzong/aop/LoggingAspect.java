package com.zkzong.aop;

import org.aspectj.lang.JoinPoint;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: zong
 * @Date: 2019.1.11
 */
public class LoggingAspect {
    public void beforeMethod(JoinPoint jp) {
        String name = jp.getSignature().getName();
        List<Object> args = Arrays.asList(jp.getArgs());
        System.out.println("MethodName is  " + name + " begins with" + args);
    }

    public void afterMethod(JoinPoint jp) {
        String name = jp.getSignature().getName();
        List<Object> args = Arrays.asList(jp.getArgs());
        System.out.println("MethodName is  " + name + " after with" + args);
    }

    public void afterReturingMethod(JoinPoint jp) {
        String name = jp.getSignature().getName();
        List<Object> args = Arrays.asList(jp.getArgs());
        System.out.println("MethodName is  " + name + " afterReturing with" + args);
    }

    public void afterTHrowingMethod(JoinPoint jp) {
        String name = jp.getSignature().getName();
        List<Object> args = Arrays.asList(jp.getArgs());
        System.out.println("MethodName is  " + name + " afterThrowing with" + args);
    }
}
