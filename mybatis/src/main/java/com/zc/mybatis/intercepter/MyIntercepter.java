package com.zc.mybatis.intercepter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Configuration
public class MyIntercepter extends HandlerInterceptorAdapter {
    private Logger logger = LoggerFactory.getLogger(MyIntercepter.class);

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object obj, Exception err)
            throws Exception {
        System.out.println("after completion");
    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object obj, ModelAndView mav)
            throws Exception {
         System.out.println("postHandle:==================>");
    }

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object obj) throws Exception {
        System.out.println("prehandle");
        return true;
    }
}
