package com.eknaij.springbootthymeleaf;

import com.eknaij.springbootthymeleaf.pojo.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class HelloController {
    @RequestMapping("/hello")
    public String hello(Model model){
        List<Product> ps = new ArrayList<>();
        ps.add(new Product(1,"product a", 50));
        ps.add(new Product(2,"product b", 100));
        ps.add(new Product(3,"product c", 150));
        ps.add(new Product(4,"product d", 200));
        ps.add(new Product(5,"product f", 200));
        ps.add(new Product(6,"product g", 200));
        Date now = new Date();
        model.addAttribute("now",now);
        model.addAttribute("ps",ps);
        model.addAttribute("hello","Hello Thymeleaf");
        return "hello";
    }
}
