package com.eknaij.springbootrestful.controller;

import com.eknaij.springbootrestful.mapper.UserMapper;
import com.eknaij.springbootrestful.pojo.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserMapper userMapper;
    @GetMapping("/users")
    //在参数里接受当前是第几页 start ，以及每页显示多少条数据 size。 默认值分别是0和5。
    public String listUser(Model model, @RequestParam(value = "start", defaultValue = "0") int start,
                               @RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        //根据start,size进行分页
        PageHelper.startPage(start,size);
        List<User> cs=userMapper.findAll();
        PageInfo<User> page = new PageInfo<>(cs);
        model.addAttribute("page", page);
        return "listUser";
    }

    @PostMapping("/users")
    public String addUser(User c) throws Exception {
        userMapper.save(c);
        return "redirect:users";
    }
    @DeleteMapping("/users/{id}")
    public String deleteUser(User c) throws Exception {
        userMapper.delete(c.getId());
        return "redirect:/users";
    }
    @PutMapping("/users/{id}")
    public String updateUser(User c) throws Exception {
        userMapper.update(c);
        return "redirect:/users";
    }

    @GetMapping("/users/{id}")
    public String getUser(@PathVariable("id")int id, Model m) throws Exception {
        User c= userMapper.get(id);
        m.addAttribute("c", c);
        return "editUser";
    }
}
