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

@Service
@Transactional(rollbackFor = Exception.class)
public class UserService {
    @Resource
    private UserDao userDao;

    /**
     * pagehelp测试
     * @param pageNo
     * @param pageSize
     * @return
     */
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
