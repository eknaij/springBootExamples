package com.eknaij.springbootmongodb.service;

import com.eknaij.springbootmongodb.pojo.User;

import java.util.List;

public interface UserService {
    public User getByUserid(int id);
    public User getByUseridLike(int id);
    public void saveUser(User user);
    public void removeUserByUserid(int id);
    public void updateUser(User user);
    public List<User> getAllUser();
    public User findOne(int id);
}
