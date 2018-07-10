package com.zc.service;

import com.zc.domain.User;
import net.minidev.json.JSONValue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void queryUserById() throws Exception {
        User user = userService.queryUserById("001");
        System.out.println(JSONValue.toJSONString(user));
    }

    @Test
    public void queryUserByName() throws Exception {
        List<User> users = userService.queryUserByName("李白");
        System.out.println(JSONValue.toJSONString(users));
    }

    @Test
    public void queryUserByAge() throws Exception {
        List<User> users = userService.queryUserByAge(111);
        System.out.println(JSONValue.toJSONString(users));
    }

    @Test
    public void queryTotalCount() throws Exception {
        Long num = userService.queryTotalCount();
        System.out.println(num);
    }

    @Test
    public void addUser() throws Exception {
        User user = new User("001", 111, "李白");
        User user1 = new User("002", 222, "李白");
        User user2 = new User("003", 111, "李黑");
        userService.addUser(user);
        userService.addUser(user1);
        userService.addUser(user2);
    }

    @Test
    public void delUser() throws Exception {
        userService.delUser("001");
    }

    @Test
    public void updUser() throws Exception {
        User user = new User("001", 222, "李黑");
        userService.updUser(user);
    }

}