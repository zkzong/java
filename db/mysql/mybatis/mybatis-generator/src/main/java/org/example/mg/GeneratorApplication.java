package org.example.mg;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: zkzong
 * @Date: 2018.9.12
 */
@SpringBootApplication
@MapperScan("com.zkzong.mg")
public class GeneratorApplication {
    public static void main(String[] args) {
        SpringApplication.run(GeneratorApplication.class, args);
    }
}
