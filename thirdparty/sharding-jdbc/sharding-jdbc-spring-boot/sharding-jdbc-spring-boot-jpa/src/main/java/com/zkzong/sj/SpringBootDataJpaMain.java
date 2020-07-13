package com.zkzong.sj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootDataJpaMain {

    public static void main(final String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(SpringBootDataJpaMain.class, args);
//        applicationContext.getBean(DemoService.class).demo();
    }
}
