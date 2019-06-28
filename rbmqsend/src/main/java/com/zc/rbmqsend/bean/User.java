package com.zc.rbmqsend.bean;

import com.alibaba.fastjson.JSON;
import org.apache.commons.codec.binary.Base64;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

public class User implements Serializable {

    private static final long serialVersionUID = 123456789999L;

    private String Id;
    private String Name;
    private Date date = new Date();

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public static void main(String[] args) {
        User user = new User();
        user.setId("123");
        user.setName("aaa");
        user.setDate(new Date());

        byte[] bytes = JSON.toJSONBytes(user);

        String base64Str = Base64.encodeBase64String(bytes);

        User user1 = JSON.parseObject(bytes, User.class);
        System.out.println(Arrays.toString(bytes));
        System.out.println(JSON.toJSONString(user1));
        System.out.println(base64Str);
    }
}
