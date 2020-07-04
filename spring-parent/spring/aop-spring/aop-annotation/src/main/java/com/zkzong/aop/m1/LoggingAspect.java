package com.zkzong.aop.m1;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Before;

import java.util.Arrays;
import java.util.List;

/**
 * 把这个类声明为一个切面，需要把类放入到IOC容器中，在声明为一个切面
 *
 * @Author: zong
 * @Date: 2019.1.11
 */
//@Aspect
//@Component
public class LoggingAspect {
    //声明该方法为一个前置通知：在目标方法开始之前执行
    @Before(value = "execution(* com.zkzong.aop..*.*(..))")
    public void beforeMethod(JoinPoint jp) {
        String name = jp.getSignature().getName();
        List<Object> args = Arrays.asList(jp.getArgs());
        System.out.println("MethodName is  " + name + " begins with" + args);
    }

    //后置通知：在目标方法执行后（无论是否发生异常），执行通知
    @After(value = "execution(* com.zkzong.aop..*.*(..))")
    public void afterMethod(JoinPoint jp) {
        String name = jp.getSignature().getName();
        List<Object> args = Arrays.asList(jp.getArgs());
        System.out.println("MethodName is  " + name + " after with" + args);
    }

    @AfterReturning(value = "execution(* com.zkzong.aop..*.*(..))")
    public void afterReturingMethod(JoinPoint jp) {
        String name = jp.getSignature().getName();
        List<Object> args = Arrays.asList(jp.getArgs());
        System.out.println("MethodName is  " + name + " afterReturing with" + args);
    }

    @AfterThrowing(value = "execution(* com.zkzong.aop..*.*(..))")
    public void afterTHrowingMethod(JoinPoint jp) {
        String name = jp.getSignature().getName();
        List<Object> args = Arrays.asList(jp.getArgs());
        System.out.println("MethodName is  " + name + " afterThrowing with" + args);
    }

    @Around(value = "execution(* com.zkzong.aop..*.*(..))")
    public Object aroundMethod(ProceedingJoinPoint point) {
        Object result = null;
        String name = point.getSignature().getName();
        List<Object> args = Arrays.asList(point.getArgs());
        try {
            //前置通知@Before()
            System.out.println("MethodName is  " + name + " begins with" + args);
            result = point.proceed();
            //返回通知，可以访问方法的返回值@AfterReturning()
            System.out.println("MethodName is  " + name + " afterReturing with" + args);
        } catch (Throwable throwable) {
            //异常通知@AfterThrowing()
            System.out.println(throwable);
            System.out.println("MethodName is  " + name + " afterThrowing with" + args);
            throw new RuntimeException();
        }
        //后置通知@After()，因为方法有可能抛出异常，所以有时候访问不到方法的返回值
        System.out.println("MethodName is  " + name + " after with" + args);
        return result;
    }
}
