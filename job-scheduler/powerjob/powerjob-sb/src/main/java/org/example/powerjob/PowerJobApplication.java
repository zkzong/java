package org.example.powerjob;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @Author: zongz
 * @Date: 2024/6/2
 */
@SpringBootApplication
@EnableScheduling
public class PowerJobApplication {
    public static void main(String[] args) {
        SpringApplication.run(PowerJobApplication.class, args);
    }
}