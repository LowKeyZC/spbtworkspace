package com.zc.service;

import com.alibaba.fastjson.JSON;
import com.zc.dao.PlayerMapper;
import com.zc.domain.Player;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PlayerServiceTest {

    @Autowired
    private PlayerService playerService;

    @Test
    public void selectPlayerById() throws Exception {
        System.out.println(JSON.toJSONString(playerService.selectPlayerById("278cd0b928714f0db5c5dca87af4eae8")));
    }

    @Test
    public void queryPlayerListPage() throws Exception {

    }

    @Test
    public void queryPlayerCount() throws Exception {
        Long num = playerService.queryPlayerCount();
        System.out.println(num);
    }

    @Test
    public void insertPlayer() throws Exception {
        Player player = new Player();
        player.setpName("李白");
        playerService.insertPlayer(player);
    }

    @Test
    public void deletePlayer() throws Exception {
        playerService.deletePlayer("123456");
    }

}