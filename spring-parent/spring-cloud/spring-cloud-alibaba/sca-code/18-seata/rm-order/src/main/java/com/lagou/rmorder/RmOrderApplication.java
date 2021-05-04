package com.lagou.rmorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class RmOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(RmOrderApplication.class, args);
    }

}
