package com.zc.mybatis.dao;

import com.zc.mybatis.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface UserDao {
    List<User> queryUsers();

    User queryUserById(String id);

    void addUser(User user);

    void delUser(String id);

    void updUser(User user);
}