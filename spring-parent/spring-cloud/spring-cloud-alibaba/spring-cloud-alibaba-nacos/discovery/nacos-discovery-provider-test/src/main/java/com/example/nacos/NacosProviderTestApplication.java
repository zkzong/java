package com.example.nacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: zong
 * @Date: 2021/4/22
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosProviderTestApplication {
    public static void main(String[] args) {
        SpringApplication.run(NacosProviderTestApplication.class, args);
    }
}
