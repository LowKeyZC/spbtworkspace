package com.zc.spbt2xstu.service;

import com.zc.spbt2xstu.dao.UserDao;
import com.zc.spbt2xstu.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service
public class UserService {
    @Resource
    private UserDao userDao;

    public User userSearch(String userId) {
        return userDao.queryUserById(userId);
    }

    public void insertUser(User user) {
        userDao.addUser(user);
    }

    public void delUser(String userId) {
        userDao.delUser(userId);
    }

    public void insert2User() throws Exception {
        User user01 = new User();
        user01.setId("001");
        user01.setName("小王");
        this.insertUser(user01);

        User user02 = new User();
        user02.setId("002");
        user02.setName("小李");

        String str = null;
        System.out.println(str.length());

        this.insertUser(user02);
        HashMap map = new HashMap();
    }
}
