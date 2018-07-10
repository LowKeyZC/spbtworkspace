package com.zc.service;

import com.zc.dao.UserDao;
import com.zc.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserDao userDao;

    /**
     * 查询User ById
     */
    public User queryUserById(String id){
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        List<User> users = this.queryUsers(map);
        if (users != null){
            return users.get(0);
        }
        return null;
    }

    /**
     * 查询User ByName
     */
    public List<User> queryUserByName(String name){
        Map<String, Object> map = new HashMap<>();
        map.put("name", name);
        return this.queryUsers(map);
    }

    /**
     * 查询User ByAge
     */
    public List<User> queryUserByAge(Integer age){
        Map<String, Object> map = new HashMap<>();
        map.put("age", age);
        return this.queryUsers(map);
    }

    /**
     * 查询所有用户
     */
    public List<User> queryAllUser(){
        return this.queryUsers(new HashMap<>());
    }

    /**
     * 查询用户总数
     */
    public Long queryTotalCount() {
        return this.queryCount(new HashMap<>());
    }

    /**
     * 新增用户
     */
    public void addUser(User user) {
        userDao.addUser(user);
    }

    /**
     * 删除用户
     */
    public void delUser(String id) {
        userDao.delUser(id);
    }

    /**
     * 更新用户
     */
    public void updUser(User user) throws Exception {
        if (StringUtils.isEmpty(user.getId())){
            throw new Exception("用户ID不能为空");
        }
        userDao.updUser(user);
    }

    /**
     * 条件查询用户数
     * @param map
     * @return
     */
    private Long queryCount(Map<String, Object> map) {
        try {
            map.putIfAbsent("id", "");
            map.putIfAbsent("name", "");
            map.putIfAbsent("age", "");
            return userDao.queryCount(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0L;
    }

    /**
     * 查询User
     * @param map
     * @return
     */
    private List<User> queryUsers(Map<String, Object> map) {
        try {
            map.putIfAbsent("id", "");
            map.putIfAbsent("name", "");
            map.putIfAbsent("age", "");
            return userDao.queryUsers(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
