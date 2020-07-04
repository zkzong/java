package com.zkzong.retry.example1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.retry.annotation.EnableRetry;

/**
 * @author rollenholt
 */
@Configuration
@EnableRetry
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class Example1 {

    @Bean
    public Service1 service() {
        return new Service1();
    }

    public static void main(String[] args) {
        final AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Example1.class);
        final Service1 service1 = applicationContext.getBean(Service1.class);
        service1.service();
    }
}

