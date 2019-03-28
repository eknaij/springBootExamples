package com.eknaij.springbootmybatis.controller;

import com.eknaij.springbootmybatis.mapper.CategoryMapper;
import com.eknaij.springbootmybatis.pojo.Category;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@Controller
public class CategoryController {
    @Autowired
    CategoryMapper categoryMapper;
    @RequestMapping("/listCategory")
    //在参数里接受当前是第几页 start ，以及每页显示多少条数据 size。 默认值分别是0和5。
    public String listCategory(Model model, @RequestParam(value = "start", defaultValue = "0") int start,
                               @RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        //根据start,size进行分页
        PageHelper.startPage(start,size);
        List<Category> cs=categoryMapper.findAll();
        PageInfo<Category> page = new PageInfo<>(cs);
        model.addAttribute("page", page);
        return "listCategory";
    }
    @RequestMapping("/addCategory")
    public String listCategory(Category c) throws Exception {
        categoryMapper.save(c);
        return "redirect:listCategory";
    }
    @RequestMapping("/deleteCategory")
    public String deleteCategory(Category c) throws Exception {
        categoryMapper.delete(c.getId());
        return "redirect:listCategory";
    }
    @RequestMapping("/updateCategory")
    public String updateCategory(Category c) throws Exception {
        categoryMapper.update(c);
        return "redirect:listCategory";
    }
    @RequestMapping("/editCategory")
    public String listCategory(int id,Model m) throws Exception {
        Category c= categoryMapper.get(id);
        m.addAttribute("c", c);
        return "editCategory";
    }
}
