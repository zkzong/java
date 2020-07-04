package com.zkzong.sb.log4j2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @Author: Zong
 * @Date: 2018/12/9
 */
@SpringBootApplication
@EnableScheduling
public class Log4j2Application {
    public static void main(String[] args) {
        SpringApplication.run(Log4j2Application.class, args);
    }
}
