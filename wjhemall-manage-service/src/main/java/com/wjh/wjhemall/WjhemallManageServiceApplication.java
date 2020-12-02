package com.wjh.wjhemall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.wjh.wjhemall.manage.mapper")
public class WjhemallManageServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(WjhemallManageServiceApplication.class, args);
    }

}
