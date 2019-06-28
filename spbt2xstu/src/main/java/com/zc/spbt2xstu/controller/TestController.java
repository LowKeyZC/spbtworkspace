package com.zc.spbt2xstu.controller;

import com.alibaba.fastjson.JSON;
import com.zc.spbt2xstu.bean.ConfigBean;
import com.zc.spbt2xstu.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Locale;

@Controller
public class TestController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private ConfigBean configBean;

    @Value("${configbean.name}")
    private String cgName;

    @Value("${configbean.randomValue}")
    private String randomValue;

    @Resource
    private MessageSource messageSource;

    @Resource
    private UserService userService;

    @RequestMapping(value = "test1")
    @ResponseBody
    public Object test1() {
        return JSON.toJSONString(userService.userSearch("123456"));
    }

    /**
     * 国际化
     * @param model
     * @return
     */
    @GetMapping("/")
    public String hello(Model model){
        Locale locale = LocaleContextHolder.getLocale();
        log.info("welcome=" + messageSource.getMessage("welcome", null, locale));
        model.addAttribute("welcomeLang", messageSource.getMessage("welcome", null, locale));
        return "hello";
    }

    /**
     * HttpSessionListener统计在线人数
     * @param httpServletRequest
     * @param httpServletResponse
     * @return
     */
    @RequestMapping("/count")
    @ResponseBody
    public String count(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        HttpSession session = httpServletRequest.getSession();
        Object count=session.getServletContext().getAttribute("count");
        return "count : "+count;
    }
}
