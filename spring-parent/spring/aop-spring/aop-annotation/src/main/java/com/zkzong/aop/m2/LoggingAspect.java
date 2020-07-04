package com.zkzong.aop.m2;

/**
 * @Author: zong
 * @Date: 2019.1.11
 */

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * 把这个类声明为一个切面，需要把类放入到IOC容器中，在声明为一个切面
 */
@Aspect
@Component
public class LoggingAspect {
    /**
     * 定义一个方法，用于声明切入点表达式，一般的，该方法中再不需要添加其他代码
     * 使用@Pointcut来声明切入点表达式
     */
    @Pointcut("execution(* com.zkzong.aop..*.*(..))")
    public void declareJointPointExpression() {
    }

    //声明该方法为一个前置通知：在目标方法开始之前执行
    @Before("declareJointPointExpression()")
    public void beforeMethod(JoinPoint jp) {
        String name = jp.getSignature().getName();
        List<Object> args = Arrays.asList(jp.getArgs());
        System.out.println("MethodName is  " + name + " begins with" + args);
    }

    @After("declareJointPointExpression()")
    public void afterMethod(JoinPoint jp) {
        String name = jp.getSignature().getName();
        List<Object> args = Arrays.asList(jp.getArgs());
        System.out.println("MethodName is  " + name + " after with" + args);
    }

    @AfterReturning("declareJointPointExpression()")
    public void afterReturingMethod(JoinPoint jp) {
        String name = jp.getSignature().getName();
        List<Object> args = Arrays.asList(jp.getArgs());
        System.out.println("MethodName is  " + name + " afterReturing with" + args);
    }

    @AfterThrowing("declareJointPointExpression()")
    public void afterTHrowingMethod(JoinPoint jp) {
        String name = jp.getSignature().getName();
        List<Object> args = Arrays.asList(jp.getArgs());
        System.out.println("MethodName is  " + name + " afterThrowing with" + args);
    }
}
