package org.example.powermock;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.example.powermock.mapper")
public class PowerMockApplication {

    public static void main(String[] args) {
        SpringApplication.run(PowerMockApplication.class, args);
    }
}
