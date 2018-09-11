package com.zc.dao;

import com.zc.domain.LevelQuestion;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LevelQuestionMapper {
    int deleteByPrimaryKey(String lqId);

    int insert(LevelQuestion record);

    int insertSelective(LevelQuestion record);

    LevelQuestion selectByPrimaryKey(String lqId);

    /**
     * 更新不为NULL字段
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(LevelQuestion record);

    /**
     * NULL属性更新库
     * @param record
     * @return
     */
    int updateByPrimaryKey(LevelQuestion record);
}