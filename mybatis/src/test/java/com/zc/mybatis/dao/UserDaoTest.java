package com.zc.mybatis.dao;

import com.zc.mybatis.entity.User;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {
    @Autowired
    private UserDao userDao;

    @Test
    public void test1_Add() {
        userDao.addUser(new User("333", 12, "springboot-mybatis-stu"));
        userDao.addUser(new User("444", 12, "springboot-mybatis-stu"));
        userDao.addUser(new User("555", 12, "springboot-mybatis-stu"));
        userDao.addUser(new User("666", 12, "springboot-mybatis-stu"));
    }

    @Test
    public void test2_Query() {
        User user = userDao.queryUserById("111");
        Assert.assertNotNull(user);
    }

    @Test
    public void test3_QueryUsers() {
        List<User> userList = userDao.queryUsers();
        System.out.println(userList.size());
    }

    @Test
    public void test4_Upd() {
        User user = userDao.queryUserById("111");
        user.setName("change-name");
        userDao.updUser(user);
    }

    @Test
    public void test5_Del() {
        userDao.delUser("111");
        Assert.assertEquals(0, userDao.queryUsers().size());
    }

}