package com.zc.spbt2xstu.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author zhouchao
 */
public class TestFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("执行Controller前的TestFilter处理");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("执行Controller后的TestFilter处理");
    }

    @Override
    public void destroy() {

    }
}
