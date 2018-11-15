package com.zc.service;

import com.alibaba.fastjson.JSON;
import com.zc.condition.LevelCondition;
import com.zc.domain.Level;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LevelServiceTest {

    @Autowired
    private LevelService levelService;

    @Test
    public void selectLevelById() throws Exception {
        Long starTM = System.currentTimeMillis();
        Level level = levelService.selectLevelById("100010");
        Long endTM = System.currentTimeMillis();
        System.out.println("查询时间:" + (endTM - starTM));
        System.out.println(JSON.toJSONString(level));
    }

    @Test
    public void selectLevelByOrder() {
//        Long starTM = System.currentTimeMillis();
//        Level level = levelService.selectLevelByOrder(199998);
//        Long endTM = System.currentTimeMillis();
//        System.out.println("查询时间:" + (endTM - starTM));
//        System.out.println(JSON.toJSONString(level));
    }

    @Test
    public void queryLevelListPage() throws Exception {
    }

    @Test
    public void insertLevel() throws Exception {
        Level level = new Level();
        for (int i = 0;i<200000;i++) {
            level.setlId(i+1+"");
            level.setlOrder(i);
            levelService.insertLevel(level);
        }
    }

    @Test
    public void queryLevelCount() throws Exception {
        System.out.println(levelService.queryLevelCount());
    }

    @Test
    public void queryOneOrList() {
        LevelCondition levelCondition = new LevelCondition();
        levelCondition.setSortRule("l_order asc");
        List<Level> list = levelService.queryByCondition(levelCondition);
        System.out.println(JSON.toJSONString(list));
    }
}