package com.zkzong.sj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootDataMybatisMain {

    public static void main(final String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(SpringBootDataMybatisMain.class, args);
//        applicationContext.getBean(DemoService.class).demo();
    }
}
