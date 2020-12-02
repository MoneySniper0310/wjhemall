package com.wjh.wjhemall.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.wjh.wjhemall.user.mapper")
public class WjhemallUserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(WjhemallUserServiceApplication.class, args);
    }

}
