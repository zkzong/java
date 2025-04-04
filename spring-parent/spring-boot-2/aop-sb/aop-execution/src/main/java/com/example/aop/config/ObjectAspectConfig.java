package com.example.aop.config;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * //匹配AOP对象的目标对象为指定类型的方法,即LogService的aop代理对象的方法
 *
 * @Pointcut("this(com.example.aop.log.Loggable)") //匹配实现Loggable接口的目标对象(而不是aop代理后的对象)的方法
 * @Pointcut("target(com.example.aop.log.Loggable)") //this 可以拦截 DeclareParents(Introduction)
 * //target 不拦截 DeclareParents(Introduction)
 * //匹配所有以Service结尾的bean里头的方法
 * @Pointcut("bean(*Service)") Created by cat on 2016-12-04.
 */
@Aspect
@Component
public class ObjectAspectConfig {

    //@Pointcut("bean(logService)")
    //@Pointcut("this(com.example.aop.log.Loggable)")
    //public void matchCondition(){}
    //
    //@Before("matchCondition()")
    //public void before(){
    //    System.out.println("");
    //    System.out.println("###before");
    //}
}
