package org.example.sj5;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "org.example.sj5.mapper")
@SpringBootApplication
public class ShardingJdbc5MybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShardingJdbc5MybatisApplication.class, args);
    }

}
