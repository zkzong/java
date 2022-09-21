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
            "&& (execution(* com.zkzong.mysql.service..*.select*(..)) " +
            "|| execution(* com.zkzong.mysql.service..*.get*(..)))")
    public void readPointcut() {

    }

    @Pointcut("@annotation(org.example.mysql.annotation.Master) " +
            "|| execution(* com.zkzong.mysql.service..*.insert*(..)) " +
            "|| execution(* com.zkzong.mysql.service..*.add*(..)) " +
            "|| execution(* com.zkzong.mysql.service..*.update*(..)) " +
            "|| execution(* com.zkzong.mysql.service..*.edit*(..)) " +
            "|| execution(* com.zkzong.mysql.service..*.delete*(..)) " +
            "|| execution(* com.zkzong.mysql.service..*.remove*(..))")
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
    //@Before("execution(* com.zkzong.mysql.service.impl.*.*(..))")
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
