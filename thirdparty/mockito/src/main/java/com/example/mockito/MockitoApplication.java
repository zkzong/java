package com.example.mockito;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.mockito.mapper")
public class MockitoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MockitoApplication.class, args);
    }
}
