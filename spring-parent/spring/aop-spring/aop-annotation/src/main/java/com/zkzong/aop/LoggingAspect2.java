package com.zkzong.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: zong
 * @Date: 2019.1.11
 */
//@Aspect
//@Order(2)
//@Component
public class LoggingAspect2 {
    //声明该方法为一个前置通知：在目标方法开始之前执行
    @Before(value = "execution(* com.zkzong.aop..*.*(..))")
    public void beforeMethod(JoinPoint jp) {
        String name = jp.getSignature().getName();
        List<Object> args = Arrays.asList(jp.getArgs());
        System.out.println("LoggingAspect2");
    }
}
