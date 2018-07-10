package com.zc.mybatis.dao;

import com.zc.mybatis.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {
    List<User> queryUsers();

    User queryUserById(String userId);

    void addUser(User user);

    void delUser(String id);

    void updUser(User user);
}