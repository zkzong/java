package org.example.sj4;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "com.zkzong.sj4.repository")
@SpringBootApplication
public class ShardingJdbc4MybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShardingJdbc4MybatisApplication.class, args);
    }

}
