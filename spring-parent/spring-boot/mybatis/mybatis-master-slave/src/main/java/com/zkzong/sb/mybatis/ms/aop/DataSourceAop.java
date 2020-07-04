package com.zkzong.sb.mybatis.ms.aop;

import com.zkzong.sb.mybatis.ms.bean.DBContextHolder;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DataSourceAop {
    @Pointcut("!@annotation(com.zkzong.sb.mybatis.ms.annotation.Master) " +
            "&& (execution(* com.zkzong.sb.mybatis.ms.service..*.select*(..)) " +
            "|| execution(* com.zkzong.sb.mybatis.ms.service..*.get*(..)))")
    public void readPointcut() {

    }

    @Pointcut("@annotation(com.zkzong.sb.mybatis.ms.annotation.Master) " +
            "|| execution(* com.zkzong.sb.mybatis.ms.service..*.insert*(..)) " +
            "|| execution(* com.zkzong.sb.mybatis.ms.service..*.add*(..)) " +
            "|| execution(* com.zkzong.sb.mybatis.ms.service..*.update*(..)) " +
            "|| execution(* com.zkzong.sb.mybatis.ms.service..*.edit*(..)) " +
            "|| execution(* com.zkzong.sb.mybatis.ms.service..*.delete*(..)) " +
            "|| execution(* com.zkzong.sb.mybatis.ms.service..*.remove*(..))")
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
    //@Before("execution(* com.zkzong.sb.mybatis.ms.service.impl.*.*(..))")
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
