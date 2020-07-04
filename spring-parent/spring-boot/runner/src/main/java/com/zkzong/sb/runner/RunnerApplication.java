package com.zkzong.sb.runner;

import com.zkzong.sb.runner.commandlinerunner.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class RunnerApplication {

    private static final Logger logger = LoggerFactory.getLogger(RunnerApplication.class);

    public static void main(String[] args) {
//		SpringApplication.run(StartupApplication.class, args);

        ConfigurableApplicationContext context = SpringApplication.run(RunnerApplication.class, args);
        HelloService service = context.getBean(HelloService.class);
        logger.info(service.getMessage());
    }
}
