package com.zc.mybatis.service;

import com.zc.mybatis.dao.UserDao;
import com.zc.mybatis.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserService {
    @Autowired
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
    }
}
