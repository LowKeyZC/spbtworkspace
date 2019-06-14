package com.zc.dbms.dao;

import com.zc.dbms.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {
    List<User> queryUsers();

    User queryUserById(String id);

    void addUser(User user);

    void delUser(String id);

    void updUser(User user);
}