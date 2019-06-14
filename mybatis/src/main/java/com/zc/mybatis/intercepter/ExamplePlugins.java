package com.zc.mybatis.intercepter;

// ExamplePlugin.java

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Signature;

import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.util.Properties;

/**
 * mybatis 自定义插件 todo 未实现
 */
@Intercepts(value = {@Signature(
        type= Executor.class,                              //这里对应4个类
        method = "query",                                 //这里对应4个类里面的参数
        args = {MappedStatement.class,Object.class, RowBounds.class, ResultHandler.class})})     //这里的参数类型，是对应4个类中的各种方法的参数。如果方法没有参数，这里直接写{}就可以了
public class ExamplePlugins implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("mybatis插件打印了乐乐");
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}