package org.example.aop.config;

/**
 * //匹配ProductService类里头的所有方法
 * @Pointcut("within(com.zkzong.aop.service.ProductService)")
 * //匹配com.imooc包及子包下所有类的方法
 * @Pointcut("within(com.zkzong.aop..*)")
 */

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PkgTypeAspectConfig {
    //@Pointcut("within(com.zkzong.aop.service.sub.*)")
    //public void matchType(){}
    //
    //@Before("matchType()")
    //public void before(){
    //    System.out.println("");
    //    System.out.println("###before");
    //}
}
