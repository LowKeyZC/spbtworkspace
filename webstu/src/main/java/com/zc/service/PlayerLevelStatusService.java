package com.zc.service;

import com.zc.dao.PlayerLevelStatusMapper;
import com.zc.domain.PlayerLevelStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PlayerLevelStatusService {

    private static Logger LOGGER = LoggerFactory.getLogger(PlayerLevelStatusService.class);

    @Autowired
    private PlayerLevelStatusMapper statusMapper;

    /**
     * 查询记录
     */
    public PlayerLevelStatus queryrPlayerLevelStatus(String id) {
        return statusMapper.selectByPrimaryKey(id);
    }

    /**
     * 插入记录
     * @param levelStatus
     */
    public void insertPlayerLevelStatus(PlayerLevelStatus levelStatus) {
        String id = UUID.randomUUID().toString().replaceAll("-", "");
        levelStatus.setPlsId(id);
        statusMapper.insert(levelStatus);
    }

    /**
     * 修改记录
     */
    public void modifyPlayerLevelStaus(PlayerLevelStatus levelStatus) {
        statusMapper.updateByPrimaryKey(levelStatus);
    }

    /**
     * 删除记录
     */
    public void deletePlayerLevelStatus(String id) {
        statusMapper.deleteByPrimaryKey(id);
    }
}
