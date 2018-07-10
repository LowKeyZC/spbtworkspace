package com.zc.dao;

import com.zc.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserDao {
    List<User> queryUsers(Map<String, Object> map);

    Long queryCount(Map<String, Object> map);

    void addUser(User user);

    void delUser(String id);

    void updUser(User user);
}
