package org.example.mysql.aop;

import org.example.mysql.bean.DBContextHolder;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DataSourceAop {

    @Pointcut("!@annotation(org.example.mysql.annotation.Master) " +
            "&& (execution(* org.example.mysql.service..*.select*(..)) " +
            "|| execution(* org.example.mysql.service..*.get*(..)))")
    public void readPointcut() {

    }

    @Pointcut("@annotation(org.example.mysql.annotation.Master) " +
            "|| execution(* org.example.mysql.service..*.insert*(..)) " +
            "|| execution(* org.example.mysql.service..*.add*(..)) " +
            "|| execution(* org.example.mysql.service..*.update*(..)) " +
            "|| execution(* org.example.mysql.service..*.edit*(..)) " +
            "|| execution(* org.example.mysql.service..*.delete*(..)) " +
            "|| execution(* org.example.mysql.service..*.remove*(..))")
    public void writePointcut() {

    }

    @Before("readPointcut()")
    public void read() {
        DBContextHolder.slave();
    }

    @Before("writePointcut()")
    public void write() {
        DBContextHolder.master();
    }


    /**
     * 另一种写法：if...else...  判断哪些需要读从数据库，其余的走主数据库
     */
    //@Before("execution(* org.example.mysql.service.impl.*.*(..))")
    //public void before(JoinPoint jp) {
    //    String methodName = jp.getSignature().getName();
    //
    //    if (StringUtils.startsWithAny(methodName, "get", "select", "find")) {
    //        DBContextHolder.slave();
    //    } else {
    //        DBContextHolder.master();
    //    }
    //}

}
