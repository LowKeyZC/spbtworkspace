package com.zc.controller;

import com.zc.common.PageBean;
import com.zc.domain.User;
import com.zc.service.UserService;
import com.zc.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AdminController {

    private static final Logger log = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    private UserService userService;

    @GetMapping("/home")
    public String index(Map<String, Object> map) {
        map.put("name", "李白");
        map.put("date", new Date());
        return "home"; //当浏览器输入/index时，会返回 /templates/home.html页面
    }

    @GetMapping("/userList")
    public String userList(){
        return "user";
    }

    /**
     * 查询年级书单列表
     * @return
     */
    @RequestMapping(value = "/list",method = RequestMethod.POST, produces="text/html;charset=UTF-8")
    public String getBookListsByGradeId(
            @RequestParam(value = "page", required = false) String page,
            @RequestParam(value = "rows", required = false) String rows,
            HttpServletResponse response) throws Exception{

        log.info("=====查询用户列表=====page="+page+"rows="+rows);
        try {
            Map<String,Object> map = new HashMap<String,Object>();
            if (page != null && rows != null) {
                PageBean pageBean = new PageBean(Integer.parseInt(page),Integer.parseInt(rows));
                map.put("start", pageBean.getStart());
                map.put("size", pageBean.getPageSize());
            }

            List<User> users = userService.queryAllUser();
            Long total = userService.queryTotalCount();

            JSONObject result = new JSONObject();
            JSONArray jsonArray = JSONArray.fromObject(users);
            result.put("rows", jsonArray);
            result.put("total",total);
            log.info("request: /list, map: " + map.toString());
            ResponseUtil.write(response, result);
            return null;
        }catch (Exception e){
            e.printStackTrace();
            return e.getMessage();
        }
    }
}
