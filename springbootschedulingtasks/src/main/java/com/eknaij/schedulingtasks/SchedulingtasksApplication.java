package com.eknaij.schedulingtasks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SchedulingtasksApplication {

    public static void main(String[] args) {
        SpringApplication.run(SchedulingtasksApplication.class, args);
    }

}
