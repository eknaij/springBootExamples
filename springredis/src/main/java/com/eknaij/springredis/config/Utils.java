package com.eknaij.springredis.config;

import com.eknaij.springredis.pojo.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class Utils {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    Gson gson = new Gson();
    /**添加操作，一下三个分别为1.添加普通的String 2.添加对象作为value 3.添加列表作为value**/
    public void add(String key,String value){
        redisTemplate.opsForValue().set(key, value);
    }

    public void add(String key,User user){
        redisTemplate.opsForValue().set(key, gson.toJson(user));
    }

    public void addList(String key,List<User> userList){
        redisTemplate.opsForValue().set(key, gson.toJson(userList));
    }
    /**根据key进行删除**/
    public boolean deleteByKey(String key){
        return redisTemplate.opsForValue().getOperations().delete(key);
    }
    /**查询返回的是一个对象**/
    public User  getByKey(String key){
        Gson gson = new Gson();
        User user = null;
        String dataJson = redisTemplate.opsForValue().get(key);
        if(dataJson != null){
            user =  gson.fromJson(dataJson, User.class);
        }
        return user;
    }
    /**查询返回的是一个列表**/
    public List<User> getUserListByKey(String key){
        List<User> userList = null;
        String userJson = redisTemplate.opsForValue().get(key);
        if(userJson != null){
            userList =  gson.fromJson(userJson, new TypeToken<List<User>>(){}.getType());
        }
        return userList;
    }


}
