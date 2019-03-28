package com.eknaij.springboot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String helloSpringBoot() {
        return "Hello Spring Boot!";
    }
}
