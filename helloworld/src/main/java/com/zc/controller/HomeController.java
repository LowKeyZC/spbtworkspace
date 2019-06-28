package com.zc.controller;

import com.sun.deploy.util.ArrayUtil;
import com.zc.bean.ConfigBean;
import jdk.nashorn.internal.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.swing.tree.TreeNode;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
public class HomeController {

    @Resource
    private ConfigBean configBean;

    @GetMapping(value = "/home")
    public String getHome() {
        System.out.println("id=" + configBean.getId() + " name=" + configBean.getName());
        return "success";
    }

    public static void main(String[] args) {
        String str = "aaaxxxbbbb";
        String result = str.replaceAll("aaa", "").replaceAll("bbbb", "");

    }

    public static String m() {
        return null;
    }

    /**
     * K 下标 L 长度 M 最大值
     * @return
     */
    public static void f() {
        try {
            String str = m();
            System.out.println(str.length());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("catch 之后");
    }

    public static String g() {
        try {
            f();
            return "aaa";
        } catch (NullPointerException e) {
            System.out.println("空指针异常!");
        } catch (Exception e) {
            System.out.println("系统异常!");
        }
        return "aaa";
    }

}
