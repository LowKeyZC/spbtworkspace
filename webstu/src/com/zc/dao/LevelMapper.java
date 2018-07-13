package com.zc.dao;

import com.zc.domain.Level;

public interface LevelMapper {
    int deleteByPrimaryKey(String lId);

    int insert(Level record);

    int insertSelective(Level record);

    Level selectByPrimaryKey(String lId);

    int updateByPrimaryKeySelective(Level record);

    int updateByPrimaryKey(Level record);
}