package com.eknaij.springbootjpa;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("/hellojpa")
    public String helloSpringBoot() {
        return "Hello Spring Boot JPA";
    }
}
