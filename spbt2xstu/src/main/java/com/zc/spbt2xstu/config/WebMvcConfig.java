package com.zc.spbt2xstu.config;

import com.zc.spbt2xstu.intercepter.TestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

/**
 * 国际化配置类
 * @author zhouchao
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    /**
     * 国际化
     */
    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver slr = new SessionLocaleResolver();
        // 默认语言
        slr.setDefaultLocale(Locale.SIMPLIFIED_CHINESE);
        return slr;
    }
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor(){
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
        // 参数名
        lci.setParamName("lang");
        return lci;
    }



    @Override
    public void addInterceptors(InterceptorRegistry registry){
        /* 国际化拦截器 */
        registry.addInterceptor(localeChangeInterceptor());

        //註冊TestInterceptor拦截器
        InterceptorRegistration registration = registry.addInterceptor(new TestInterceptor());
        //所有路径都被拦截
        registration.addPathPatterns("/**");
        //添加不拦截路径
        registration.excludePathPatterns("/","/error","/static/**");
    }
}
