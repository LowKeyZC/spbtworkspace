package com.zc.dbms.controller;

import com.github.pagehelper.PageInfo;
import com.zc.dbms.entity.User;
import com.zc.dbms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * jemeter高并发测试
 * 144W数据
 * 100并发
 */

@RestController
@RequestMapping(value = "hello")
public class HelloController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "userSearch", method = RequestMethod.GET)
    public User userSearch(@RequestParam(value = "userId") String userId) {
        Long time01 = System.currentTimeMillis();
        User user = userService.userSearch(userId);
        System.out.println("userSearch耗时=" + (System.currentTimeMillis() - time01));
        return user;
    }

    @RequestMapping(value = "queryUsers")
    public PageInfo<User> queryUsers(@RequestParam Integer pageNo,
                                     @RequestParam Integer pageSize) {
        return userService.selectUsers(pageNo, pageSize);
    }
}
