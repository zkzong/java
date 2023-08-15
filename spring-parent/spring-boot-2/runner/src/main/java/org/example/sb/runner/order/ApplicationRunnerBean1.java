package com.example.sb.runner.order;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author zkzong
 * @date 2017/11/30
 */
@Component
@Order(2)
public class ApplicationRunnerBean1 implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments arg0) throws Exception {
        System.out.println("ApplicationRunnerBean 1");
    }
}
