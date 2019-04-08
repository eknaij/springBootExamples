package com.eknaij.springbootmongodb.serviceImpl;

import com.eknaij.springbootmongodb.dao.UserDao;
import com.eknaij.springbootmongodb.pojo.User;
import com.eknaij.springbootmongodb.service.UserService;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private MongoTemplate mongoTemplate;
    @Resource
    private UserDao userDao;

    @Override
    public User getByUserid(int id) {
        return userDao.getByUserId(id);
    }

    @Override
    public User getByUseridLike(int id) {
        return userDao.getByUserIdLike(id);
    }

    @Override
    public void saveUser(User user) {
        userDao.save(user);
    }

    @Override
    public void removeUserByUserid(int id) {
        Query q=new Query(new Criteria("userId").is(id));
        mongoTemplate.remove(q,User.class);
    }

    @Override
    public void updateUser(User user) {
        Query q=new Query(new Criteria("userId").is(user.getUserId()));
        Update update=new Update();
        update.set("userId", user.getUserId());
        update.set("name", user.getName());
        mongoTemplate.updateMulti(q, update,User.class);
    }

    @Override
    public List<User> getAllUser() {
        return userDao.findAll();
    }

    @Override
    public User findOne(int id) {
        Query q=new Query(new Criteria("userId").is(id));
        return mongoTemplate.findOne(q,User.class);
    }
}
