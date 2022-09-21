package org.example.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: zong
 * @Date: 2019.2.21
 */
@SpringBootApplication
@EnableEurekaClient
public class AdminClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdminClientApplication.class, args);
    }
}
