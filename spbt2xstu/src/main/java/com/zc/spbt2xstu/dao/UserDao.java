package com.zc.spbt2xstu.dao;

import com.zc.spbt2xstu.entity.User;
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