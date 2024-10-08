package com.example.starrocks;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.starrocks.mapper")
public class StarRocksApplication {

    public static void main(String[] args) {
        SpringApplication.run(StarRocksApplication.class, args);
    }

}
