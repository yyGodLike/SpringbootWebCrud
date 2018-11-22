package com.lhy.resultcrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ResultcrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(ResultcrudApplication.class, args);
    }
}
