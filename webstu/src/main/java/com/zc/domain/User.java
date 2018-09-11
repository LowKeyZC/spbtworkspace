package com.zc.domain;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class User implements Comparable<User> {
    private String id;
    private String name;
    private Integer age;
    private Integer order;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    @Override
    public int compareTo(User o) {
        Integer re = Integer.compare(o.getAge(), this.getAge());
        if (re == 0) {
            re = Integer.compare(o.getOrder(), this.order);
        }
        return re;
    }

    public static void main(String[] args) {
        User user = new User();
        user.setId("aaa");
        user.setAge(111);
        user.setOrder(123);

        User user2 = new User();
        user2.setId("bbb");
        user2.setAge(111);
        user2.setOrder(234);

        List<User> users = new ArrayList<>();
        users.add(user);
        users.add(user2);

        Collections.sort(users);

        System.out.println(JSON.toJSONString(users));
    }
}
