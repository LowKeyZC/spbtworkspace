package com.zc.redisstu.bean;

import org.springframework.cache.annotation.Cacheable;

import java.io.Serializable;
import java.util.Date;

@Cacheable
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
}
