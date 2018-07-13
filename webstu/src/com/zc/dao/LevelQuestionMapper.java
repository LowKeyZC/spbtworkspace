package com.zc.dao;

import com.zc.domain.LevelQuestion;

public interface LevelQuestionMapper {
    int deleteByPrimaryKey(String lqId);

    int insert(LevelQuestion record);

    int insertSelective(LevelQuestion record);

    LevelQuestion selectByPrimaryKey(String lqId);

    int updateByPrimaryKeySelective(LevelQuestion record);

    int updateByPrimaryKey(LevelQuestion record);
}