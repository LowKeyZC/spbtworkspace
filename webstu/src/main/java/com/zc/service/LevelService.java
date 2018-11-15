package com.zc.service;

import com.zc.condition.LevelCondition;
import com.zc.dao.LevelMapper;
import com.zc.domain.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LevelService {

    @Autowired
    private LevelMapper levelMapper;

    public Level selectLevelById(String lId){
        return levelMapper.selectByPrimaryKey(lId);
    }
//
//    public Level selectLevelByOrder(Integer order) {
//        Map<String, Object> map = new HashMap<>();
//        map.put("lOrder", order);
//        return levelMapper.queryOneOrList(map).get(0);
//    }
//
//    public List<Level> queryLevelListPage(Integer start, Integer size) {
//        Map<String, Object> map = new HashMap<>();
//        map.put("start", start);
//        map.put("size", size);
//        return levelMapper.queryOneOrList(map);
//    }

    public void insertLevel(Level level) {
        String id = UUID.randomUUID().toString().replaceAll("-", "");
        level.setlId(id);
        levelMapper.insert(level);
    }

    public Long queryLevelCount() {
        return levelMapper.queryLevelCount();
    }

    public List<Level> queryByCondition(LevelCondition levelCondition) {
        return levelMapper.queryByCondition(levelCondition);
    }

//    public Integer insertLevel(Level level) {
//        return
//    }
//
//    public Long queryPlayerCount(){
//        return playerMapper.queryPlayerCount();
//    }
//
    public Integer insertPlayer(Level level) {
        return levelMapper.insert(level);
    }
//
//    public Integer deletePlayer(String id){
//        return playerMapper.deleteByPrimaryKey(id);
//    }
}
