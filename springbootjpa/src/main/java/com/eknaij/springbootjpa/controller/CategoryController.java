package com.eknaij.springbootjpa.controller;

import com.eknaij.springbootjpa.dao.CategoryDAO;
import com.eknaij.springbootjpa.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    CategoryDAO categoryDAO;

    //查询所有
    @RequestMapping("/listCategory")
    //在参数里接受当前是第几页 start ，以及每页显示多少条数据 size。 默认值分别是0和5
    public String listCategory(Model model, @RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        start = start<0?0:start;                //如果 start 为负，那么修改为0. 这样在首页点击上一页的时候就会停留在首页
        //设置排序方式，ASC是顺序，DESC是倒序
        Sort sort = new Sort(Sort.Direction.ASC,"id");
        Pageable pageable = new PageRequest(start, size, sort);
        Page<Category> page =categoryDAO.findAll(pageable);
        model.addAttribute("page", page);
        return "listCategory";
    }

    //添加
    @RequestMapping("/addCategory")
    public String addCategory(Category c) throws Exception {
        categoryDAO.save(c);
        return "redirect:listCategory";
    }
    //删除
    @RequestMapping("/deleteCategory")
    public String deleteCategory(Category c) throws Exception {
        categoryDAO.delete(c);
        return "redirect:listCategory";
    }
    //修改
    @RequestMapping("/updateCategory")
    public String updateCategory(Category c) throws Exception {
        categoryDAO.save(c);
        return "redirect:listCategory";
    }
    //编辑
    @RequestMapping("/editCategory")
    public String editCategory(int id,Model model) throws Exception {
        Category c= categoryDAO.getOne(id);
        model.addAttribute("c", c);
        return "editCategory";
    }

}
