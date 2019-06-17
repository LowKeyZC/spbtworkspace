package com.zc.dbms.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zc.dbms.annotation.Master;
import com.zc.dbms.dao.UserDao;
import com.zc.dbms.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserService {
    @Resource
    private UserDao userDao;

//    @Master
    public PageInfo<User> selectUsers(int pageNo, int pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        List<User> users = userDao.queryUsers();
        return new PageInfo<>(users);
    }

    public User userSearch(String userId) {
        return userDao.queryUserById(userId);
    }

    public void insertUser(User user) {
        user.setId(UUID.randomUUID().toString().replaceAll("-",""));
        userDao.addUser(user);
    }

    public void delUser(String userId) {
        userDao.delUser(userId);
    }

    public boolean insert2User() throws Exception {
        User user = new User();
        user.setName("李白");
        user.setAge(13);
        this.insertUser(user);
        return true;
    }
}
