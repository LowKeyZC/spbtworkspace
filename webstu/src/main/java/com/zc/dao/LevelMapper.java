package com.zc.dao;

import com.zc.condition.LevelCondition;
import com.zc.domain.Level;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LevelMapper {

    List<Level> queryByCondition(LevelCondition levelCondition);

    Long queryLevelCount();

    int deleteByPrimaryKey(String lId);

    int insert(Level record);

    int insertSelective(Level record);

    Level selectByPrimaryKey(String lId);

    int updateByPrimaryKeySelective(Level record);

    int updateByPrimaryKey(Level record);
}