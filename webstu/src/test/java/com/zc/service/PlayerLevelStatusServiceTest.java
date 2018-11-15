package com.zc.service;

import com.alibaba.fastjson.JSON;
import com.zc.contants.LevelStatus;
import com.zc.domain.PlayerLevelStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PlayerLevelStatusServiceTest {

    @Autowired
    private PlayerLevelStatusService playerLevelStatusService;

    @Test
    public void queryrPlayerLevelStatus() throws Exception {
        PlayerLevelStatus plStatus = playerLevelStatusService.queryrPlayerLevelStatus("123");
        System.out.println(JSON.toJSONString(plStatus));
    }

    @Test
    public void insertPlayerLevelStatus() throws Exception {
        PlayerLevelStatus plStatus = new PlayerLevelStatus();
        plStatus.setPlsId("123");
        plStatus.setPlsLevelId("456");
        plStatus.setPlsPlayerId("789");
        plStatus.setPlsStatus(LevelStatus.STARONE);
        playerLevelStatusService.insertPlayerLevelStatus(plStatus);
    }

    @Test
    public void modifyPlayerLevelStaus() throws Exception {
    }

    @Test
    public void deletePlayerLevelStatus() throws Exception {
    }

}