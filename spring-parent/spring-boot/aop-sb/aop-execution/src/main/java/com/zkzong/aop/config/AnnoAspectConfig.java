package com.zkzong.aop.config;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * //匹配方法标注有AdminOnly的注解的方法
 *
 * @Pointcut("@annotation(com.zkzong.aop.anno.AdminOnly) && within(com.zkzong.aop..*)")
 * //匹配标注有NeedSecured的类底下的方法 //class级别
 * @Pointcut("@within(com.zkzong.aop.anno.NeedSecured) && within(com.zkzong.aop..*)")
 * //匹配标注有NeedSecured的类及其子类的方法 //runtime级别
 * 在spring context的环境下,二者没有区别
 * @Pointcut("@target(com.zkzong.aop.anno.NeedSecured) && within(com.zkzong.aop..*)")
 * //匹配传入的参数类标注有Repository注解的方法
 * @Pointcut("@args(com.zkzong.aop.anno.NeedSecured) && within(com.zkzong.aop..*)")
 */
@Aspect
@Component
public class AnnoAspectConfig {

    //@Pointcut("@annotation(com.zkzong.aop.anno.AdminOnly) && within(com.zkzong.aop..*)")
    //@Pointcut("@args(com.zkzong.aop.anno.NeedSecured) && within(com.zkzong.aop..*)")
    //public void matchAnno() {
    //}
    //
    //@Before("matchAnno()")
    //public void before() {
    //    System.out.println("");
    //    System.out.println("###before");
    //}

}
