package org.example.clickhouse;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"org.example.clickhouse.mapper"})
public class ClickHouseApplication {
    public static void main(String[] args) {
        SpringApplication.run(ClickHouseApplication.class, args);
    }
}
