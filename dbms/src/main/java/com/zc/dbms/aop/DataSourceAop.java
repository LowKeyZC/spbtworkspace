package com.zc.dbms.aop;

import com.zc.dbms.bean.DBContextHolder;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class DataSourceAop {
    @Pointcut("!@annotation(com.zc.dbms.annotation.Master)" +
            "&&(execution(* com.zc.dbms.service..*.select*(..))" +
            "|| execution(* com.zc.dbms.service..*.get*(..)))")
    public void readPointcut() {}

    @Pointcut("@annotation(com.zc.dbms.annotation.Master) " +
            "|| execution(* com.zc.dbms.service..*.insert*(..)) " +
            "|| execution(* com.zc.dbms.service..*.add*(..)) " +
            "|| execution(* com.zc.dbms.service..*.update*(..)) " +
            "|| execution(* com.zc.dbms.service..*.edit*(..)) " +
            "|| execution(* com.zc.dbms.service..*.delete*(..)) " +
            "|| execution(* com.zc.dbms.service..*.remove*(..))")
    public void writePointcut() {}

    @Before("readPointcut()")
    public void read() {
        DBContextHolder.slave();
    }

    @Before("writePointcut()")
    public void write() {
        DBContextHolder.master();
    }
}
