package com.zc.dao;

import com.zc.domain.Player;

public interface PlayerMapper {
    int deleteByPrimaryKey(String pId);

    int insert(Player record);

    int insertSelective(Player record);

    Player selectByPrimaryKey(String pId);

    int updateByPrimaryKeySelective(Player record);

    int updateByPrimaryKey(Player record);
}