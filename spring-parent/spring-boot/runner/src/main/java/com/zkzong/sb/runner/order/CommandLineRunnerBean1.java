package com.zkzong.sb.runner.order;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author zkzong
 * @date 2017/11/30
 */
@Component
@Order(1)
public class CommandLineRunnerBean1 implements CommandLineRunner {
    @Override
    public void run(String... args) {
        System.out.println("CommandLineRunnerBean 1");
    }
}
