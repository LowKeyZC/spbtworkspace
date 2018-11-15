package com.zc.service;

import com.zc.dao.PlayerMapper;
import com.zc.domain.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class PlayerService {

    @Autowired
    private PlayerMapper playerMapper;

    public Player selectPlayerById(String pId){
        Map<String, Object> map = new HashMap<>();
        map.put("pId", pId);
        List<Player> players = playerMapper.queryOneOrList(map);
        if (null != players && players.size() > 0) {
            return players.get(0);
        }
        return null;
    }

    public List<Player> queryPlayerListPage(Integer start, Integer size) {
        Map<String, Object> map = new HashMap<>();
        map.put("start", start);
        map.put("size", size);
        return playerMapper.queryOneOrList(map);
    }

    public Long queryPlayerCount(){
        return playerMapper.queryPlayerCount();
    }

    public Integer insertPlayer(Player player) {
        String id = UUID.randomUUID().toString().replaceAll("-", "");
        player.setpId(id);
        return playerMapper.insert(player);
    }

    public Integer deletePlayer(String id){
        return playerMapper.deleteByPrimaryKey(id);
    }
}