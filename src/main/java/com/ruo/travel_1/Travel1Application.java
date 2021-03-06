package com.ruo.travel_1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan(value = "com.ruo.travel_1.mapper")
public class Travel1Application {

    public static void main(String[] args) {
        SpringApplication.run(Travel1Application.class, args);
    }

}
