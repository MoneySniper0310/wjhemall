package com.wjh.wjhemall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.wjh.wjhemall.cart.mapper")
public class WjhemallCartServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(WjhemallCartServiceApplication.class, args);
    }

}
