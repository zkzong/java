package com.example.aop.config;//package com.imooc.config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Before("matchAnno()")
 * @After("matchAnno())") //相当于finally
 * @AfterReturning("matchException()")
 * @AfterThrowing("matchException()")
 * @Around("matchException()")
 * @Before(value = "matchLongArg() && args(productId)")
 * public void beforeWithArgs(Long productId)
 * @AfterReturning(value = "matchReturn()",returning = "returnValue")
 * public void getReulst(Object returnValue)
 */
@Aspect
@Component
public class AdviceAspectConfig {

    /******pointcut********/

    @Pointcut("@annotation(com.example.aop.anno.AdminOnly) && within(com.example.aop..*)")
    public void matchAnno() {
    }

    @Pointcut("execution(* *..find*(Long)) && within(com.example.aop..*) ")
    public void matchLongArg() {
    }

    @Pointcut("execution(public * com.example.aop.service..*Service.*(..) throws java.lang.IllegalAccessException) && within(com.example.aop..*)")
    public void matchException() {
    }

    @Pointcut("execution(String com.example.aop..*.*(..)) && within(com.example.aop..*)")
    public void matchReturn() {
    }


    /******advice********/
    //@After("matchAnno()")
    //public void after() {
    //    System.out.println("###after");
    //}

    // 抛出异常也会执行After
    //@After("matchException()")
    //public void after() {
    //    System.out.println("###after");
    //}

    // 抛出异常时执行
    //@AfterThrowing("matchException()")
    //public void afterException() {
    //    System.out.println("###after");
    //}

    // 不抛出异常不执行
    //@AfterThrowing("matchAnno()")
    //public void afterException() {
    //    System.out.println("###after");
    //}

    //@AfterReturning(value = "matchReturn()", returning = "result")
    //public void afterException(Object result) {
    //    System.out.println("###after returnning : " + result);
    //}
    @Before("matchLongArg() && args(productId)")
    public void before(Long productId) {
        System.out.println("###before,get args:" + productId);
    }

    //@Around("matchAnno()")
    //public Object after(ProceedingJoinPoint joinPoint) {
    //    System.out.println("###before");
    //    Object result = null;
    //    try {
    //        result = joinPoint.proceed(joinPoint.getArgs());
    //        System.out.println("###after returning");
    //    } catch (Throwable e) {
    //        System.out.println("###ex");
    //        //throw
    //        e.printStackTrace();
    //    } finally {
    //        System.out.println("###finally");
    //    }
    //    return result;
    //}

}
