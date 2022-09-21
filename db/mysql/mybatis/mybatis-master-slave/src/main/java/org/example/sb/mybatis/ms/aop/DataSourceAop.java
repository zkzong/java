package org.example.sb.mybatis.ms.aop;

import org.example.sb.mybatis.ms.bean.DBContextHolder;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DataSourceAop {
    @Pointcut("!@annotation(org.example.sb.mybatis.ms.annotation.Master) " +
            "&& (execution(* org.example.sb.mybatis.ms.service..*.select*(..)) " +
            "|| execution(* org.example.sb.mybatis.ms.service..*.get*(..)))")
    public void readPointcut() {

    }

    @Pointcut("@annotation(org.example.sb.mybatis.ms.annotation.Master) " +
            "|| execution(* org.example.sb.mybatis.ms.service..*.insert*(..)) " +
            "|| execution(* org.example.sb.mybatis.ms.service..*.add*(..)) " +
            "|| execution(* org.example.sb.mybatis.ms.service..*.update*(..)) " +
            "|| execution(* org.example.sb.mybatis.ms.service..*.edit*(..)) " +
            "|| execution(* org.example.sb.mybatis.ms.service..*.delete*(..)) " +
            "|| execution(* org.example.sb.mybatis.ms.service..*.remove*(..))")
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
    //@Before("execution(* org.example.sb.mybatis.ms.service.impl.*.*(..))")
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
