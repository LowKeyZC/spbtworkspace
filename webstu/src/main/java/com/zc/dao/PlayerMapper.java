package com.zc.dao;

import com.zc.domain.Player;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface PlayerMapper {
    int deleteByPrimaryKey(String pId);

    int insert(Player record);

    int insertSelective(Player record);

    List<Player> queryOneOrList(Map<String, Object> map);

    Long queryPlayerCount();

    int updateByPrimaryKeySelective(Player record);

    int updateByPrimaryKey(Player record);
}