package com.wjh.wjhemall.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.wjh.wjhemall.user.mapper")
public class WjhemallUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(WjhemallUserApplication.class, args);
    }

}
