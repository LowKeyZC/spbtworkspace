package com.zc.dbms.service;

import com.github.pagehelper.PageInfo;
import com.zc.dbms.entity.User;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootContextLoader;
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
    public void selectUsers() throws Exception {
        PageInfo<User> users = userService.selectUsers(1, 3);
        System.out.println(users.toString());
    }
}