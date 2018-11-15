package com.zc.controller;

import com.alibaba.fastjson.JSON;
import com.zc.TestDto;
import com.zc.common.PageBean;
import com.zc.common.Result;
import com.zc.common.ResultGenerator;
import com.zc.domain.Player;
import com.zc.service.PlayerService;
import com.zc.util.ResponseUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "player")
public class PlayerController {

    private static final Logger log = LoggerFactory.getLogger(PlayerController.class);

    @Autowired
    private PlayerService playerService;

    @RequestMapping(value = "listPlayer")
    public String listPlayer(@RequestParam(value = "page", required = false) String page,
                                   @RequestParam(value = "rows", required = false) String rows,
                                   HttpServletResponse response) throws Exception {
        log.info("=====查询学生列表=====page="+page+"rows="+rows);
        try {
            Map<String,Integer> map = new HashMap<>();
            if (page != null && rows != null) {
                PageBean pageBean = new PageBean(Integer.parseInt(page),Integer.parseInt(rows));
                map.put("start", pageBean.getStart());
                map.put("size", pageBean.getPageSize());
            }

            List<Player> players = playerService.queryPlayerListPage(map.get("start"), map.get("size"));
            Long total = playerService.queryPlayerCount();

            JSONObject result = new JSONObject();
            JSONArray jsonArray = JSONArray.fromObject(players);
            result.put("rows", jsonArray);
            result.put("total",total);
            ResponseUtil.write(response, result);
            return null;
        }catch (Exception e){
            e.printStackTrace();
            return e.getMessage();
        }
    }

    @RequestMapping(value = "addPlayer")
    public Result addPlayer(@RequestBody Player player){
        log.info("=====新增学生接口，参数:" + JSON.toJSONString(player));
        try {
            playerService.insertPlayer(player);
        }catch (Exception e){
            e.printStackTrace();
            return ResultGenerator.genFailResult(e.getMessage());
        }
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping(value = "deletePlayer")
    public Result deletePlayer(@RequestParam String playerId){
        log.info("=====删除学生接口，playerId:" + playerId);
        try {
            playerService.deletePlayer(playerId);
        }catch (Exception e){
            e.printStackTrace();
            return ResultGenerator.genFailResult(e.getMessage());
        }
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping(value = "test01",method = RequestMethod.POST)
    @ResponseBody
    public Result test(@RequestBody TestDto testDto) {
        System.out.println("list01："+JSON.toJSONString(testDto.getList01()));
        System.out.println("list01："+JSON.toJSONString(testDto.getList02()));
        return ResultGenerator.genSuccessResult();
    }
    @RequestMapping(value = "test02",method = RequestMethod.POST)
    @ResponseBody
    public Result test(@RequestBody List<List> lists) {
        System.out.println("list01："+JSON.toJSONString(lists.get(0)));
        System.out.println("list01："+JSON.toJSONString(lists.get(1)));
        return ResultGenerator.genSuccessResult();
    }

    public static void main(String[] args) throws Exception {
        try {
            throw new Exception("=========error====");
        } catch (Exception e) {
            throw e;
        }
    }
}