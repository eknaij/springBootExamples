package com.eknaij.springbootthymeleaf.controller;

import com.eknaij.springbootthymeleaf.mapper.UserMapper;
import com.eknaij.springbootthymeleaf.pojo.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserMapper userMapper;

    //添加
    @RequestMapping("/addUser")
    public String listUser(User user) throws Exception {
        userMapper.save(user);
        return "redirect:listUser";
    }
    //删除
    @RequestMapping("/deleteUser")
    public String deleteUser(User user) throws Exception {
        userMapper.delete(user.getId());
        return "redirect:listUser";
    }
    //修改
    @RequestMapping("/updateUser")
    public String updateUser(User user) throws Exception {
        userMapper.update(user);
        return "redirect:listUser";
    }
    //查找(用于修改)
    @RequestMapping("/findUser")
    public String findUser(int id, Model model) throws Exception {
        User user= userMapper.get(id);
        model.addAttribute("user", user);
        return "edituser";
    }
    //遍历
    @RequestMapping("/listUser")
    public String listUser(Model model, @RequestParam(value = "start", defaultValue = "0") int start,
                           @RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        PageHelper.startPage(start,size,"id asc");
        List<User> userList=userMapper.findAll();
        PageInfo<User> page = new PageInfo<>(userList);
        model.addAttribute("pages", page);
        return "listuser";
    }
}
