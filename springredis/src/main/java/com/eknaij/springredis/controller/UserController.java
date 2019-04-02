package com.eknaij.springredis.controller;

import com.eknaij.springredis.pojo.User;
import com.eknaij.springredis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController

public class UserController {
    @Autowired
    UserService userService;

    //模拟添加数据
    @RequestMapping("/add")
    public String addRedisData(){
        userService.redisInitData();
        return "success";
    }
    @RequestMapping("/getUserByKey")
    public Map<String,Object> getUserRedisByKey(String key){
        Map<String,Object> result = new HashMap<String, Object>();
        User user = userService.getUserRedis(key);
        result.put("occupation",user.getOccupation());
        result.put("name", user.getName());
        return result;
    }

    @RequestMapping("/getUserList")
    public List getUserList(String key){
        List ls = userService.getUserList(key);
        return ls;
    }
    @RequestMapping("/deleteUserByKey")
    public String deleteUserByKey(String key){
        if(userService.deleteUserByKey(key))
            return "删除成功";
        return "删除失败";
    }

}
