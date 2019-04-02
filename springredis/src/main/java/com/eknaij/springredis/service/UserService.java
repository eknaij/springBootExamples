package com.eknaij.springredis.service;

import com.eknaij.springredis.config.Utils;
import com.eknaij.springredis.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService  {
    @Autowired
    Utils redisUtils;
    public void redisInitData(){
        redisUtils.add("添加key","添加value");
        //测试添加对象
        User user =new User();
        user.setOccupation("医生");
        user.setName("小明");
        redisUtils.add(user.getOccupation(),user);
        //测试添加列表
        List<User> ls = new ArrayList();
        User user2 =new User();
        user2.setOccupation("列表里的对象1");
        user2.setName("列表里的对象11");
        User user3=new User();
        user3.setOccupation("列表里的对象2");
        user3.setName("列表里的对象22");
        ls.add(user2);
        ls.add(user3);
        redisUtils.addList("列表",ls);
    }
    public User getUserRedis(String key){
        User user = redisUtils.getByKey(key);
        return user;
    }
    public List<User> getUserList(String key){
        List ls = redisUtils.getUserListByKey(key);
        return ls;
    }
    public boolean deleteUserByKey(String key){
        return redisUtils.deleteByKey(key);
    }

}
