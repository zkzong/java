package com.zkzong.sj5;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "com.zkzong.sj5.repository")
@SpringBootApplication
public class ShardingJdbc5MybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShardingJdbc5MybatisApplication.class, args);
    }

}
