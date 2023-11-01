package com.bbanddak.bbanddak;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.bbanddak.bbanddak.mapper") // mybatis 사용
public class BbanddakApplication {

    public static void main(String[] args) {
        SpringApplication.run(BbanddakApplication.class, args);
    }

}
