package com.example.aop.config;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * //匹配任何公共方法
 *
 * @Pointcut("execution(public * com.imooc.service.*.*(..))")
 * <p>
 * //匹配com.imooc包及子包下Service类中无参方法
 * @Pointcut("execution(* com.imooc..*Service.*())")
 * <p>
 * //匹配com.imooc包及子包下Service类中的任何只有一个参数的方法
 * @Pointcut("execution(* com.imooc..*Service.*(*))")
 * <p>
 * //匹配com.imooc包及子包下任何类的任何方法
 * @Pointcut("execution(* com.imooc..*.*(..))")
 * <p>
 * //匹配com.imooc包及子包下返回值为String的任何方法
 * @Pointcut("execution(String com.imooc..*.*(..))")
 * <p>
 * //匹配异常
 * execution(public * com.imooc.service.*.*(..) throws java.lang.IllegalAccessException)
 * <p>
 */
@Aspect
@Component
public class ExecutionAspectConfig {

    //@Pointcut("execution(public * com.example.aop.service..*Service.*(..) throws java.lang.IllegalAccessException)")
    //public void matchCondition() {
    //}
    //
    //@Before("matchCondition()")
    //public void before() {
    //    System.out.println("");
    //    System.out.println("###before");
    //}

}
