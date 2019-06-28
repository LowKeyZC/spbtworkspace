package com.zc.spbt2xstu.config;

import com.zc.spbt2xstu.filter.TestFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean //将方法中返回的对象注入到IOC容器中
    public FilterRegistrationBean<TestFilter> filterRegiste(){
        FilterRegistrationBean<TestFilter> reFilter = new FilterRegistrationBean<>();
        //创建并注册TestFilter
        reFilter.setFilter(new TestFilter());
        //拦截的路径（对所有请求拦截）
        reFilter.addUrlPatterns("/*");
        //拦截器的名称
        reFilter.setName("TestFilter");
        //拦截器的执行顺序。数字越小越先执行
        reFilter.setOrder(1);
        return  reFilter;

    }
}
