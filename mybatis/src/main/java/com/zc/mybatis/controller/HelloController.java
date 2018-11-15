package com.zc.mybatis.controller;

import com.zc.mybatis.entity.StudentBookStatus;
import com.zc.mybatis.entity.User;
import com.zc.mybatis.service.StudentBookStatusService;
import com.zc.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * jemeter高并发测试
 * 144W数据
 * 100并发
 */

@RestController
@RequestMapping(value = "hello")
public class HelloController {

    @Autowired
    private StudentBookStatusService sbsService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "select",method = RequestMethod.GET)
    public List<StudentBookStatus> select() {
        Long time01 = System.currentTimeMillis();
        List<StudentBookStatus> studentBookStatuses = sbsService.selectBatch("123", "123", "123");
        System.out.println("select耗时=" + (System.currentTimeMillis() - time01));
        return studentBookStatuses;
    }

    @RequestMapping(value = "count", method = RequestMethod.GET)
    public Long count(@RequestParam(value = "bookId") String bookId) {
        Long time01 = System.currentTimeMillis();
        Long TM = sbsService.countById(bookId);
        System.out.println("count耗时=" + (System.currentTimeMillis() - time01));
        return TM;
    }

    @RequestMapping(value = "userSearch", method = RequestMethod.GET)
    public User userSearch(@RequestParam(value = "userId") String userId) {
        Long time01 = System.currentTimeMillis();
        User user = userService.userSearch(userId);
        System.out.println("userSearch耗时=" + (System.currentTimeMillis() - time01));
        return user;
    }
}
