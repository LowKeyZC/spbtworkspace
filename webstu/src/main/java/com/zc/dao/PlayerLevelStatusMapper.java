package com.zc.dao;

import com.zc.domain.PlayerLevelStatus;

public interface PlayerLevelStatusMapper {
    int deleteByPrimaryKey(String plsId);

    int insert(PlayerLevelStatus record);

    int insertSelective(PlayerLevelStatus record);

    PlayerLevelStatus selectByPrimaryKey(String plsId);

    int updateByPrimaryKeySelective(PlayerLevelStatus record);

    int updateByPrimaryKey(PlayerLevelStatus record);
}