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

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {
    @Autowired
    private UserDao userDao;

    @Test
    public void test1_Add() {
        User user = new User();
        user.setName("aaa");
        Long starTM = System.currentTimeMillis();
        for (int i=0;i<100000;i++) {
            user.setId(String.valueOf(i));
            userDao.addUser(user);
        }
        Long endTM = System.currentTimeMillis();
        System.out.println("单线程插入100000条记录耗时：" + (endTM - starTM));
        /*单线程插入100000条记录耗时：303855*/
    }

    @Test
    public void test2_Add() {
        User user = new User();
        user.setName("aaa");
        Long starTM = System.currentTimeMillis();

        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 100000; i++) {
            final String j = String.valueOf(i);
            fixedThreadPool.execute(() -> {
                user.setId(j);
                userDao.addUser(user);
            });
        }

        Long endTM = System.currentTimeMillis();
        System.out.println("多线程插入100000条记录耗时：" + (endTM - starTM));
    }

    @Test
    public void test2_Query() {
        User user = userDao.queryUserById("123");
        Assert.assertNotNull(user);
    }

    @Test
    public void test3_QueryUsers() {
        List<User> userList = userDao.queryUsers();
        System.out.println(userList.size());
    }

    @Test
    public void test4_Upd() {
        User user = userDao.queryUserById("123");
        user.setName("change-name");
        userDao.updUser(user);
    }

    @Test
    public void test5_Del() {
        userDao.delUser("111");
        Assert.assertEquals(0, userDao.queryUsers().size());
    }

}