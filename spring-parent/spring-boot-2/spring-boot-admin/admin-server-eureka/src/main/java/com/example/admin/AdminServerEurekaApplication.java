package com.example.admin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: zong
 * @Date: 2021/11/21
 */
@SpringBootApplication
@EnableAdminServer
@EnableEurekaClient
public class AdminServerEurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdminServerEurekaApplication.class, args);
    }
}
