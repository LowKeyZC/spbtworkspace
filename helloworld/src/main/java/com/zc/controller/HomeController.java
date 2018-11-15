package com.zc.controller;

import com.sun.deploy.util.ArrayUtil;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;

import javax.swing.tree.TreeNode;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Controller
public class HomeController {

    @GetMapping(value = "/home")
    public String getHome() {
        return "home3";
    }

    public static void main(String[] args) {
        Long a = Long.valueOf(null);
        System.out.println(a);
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
