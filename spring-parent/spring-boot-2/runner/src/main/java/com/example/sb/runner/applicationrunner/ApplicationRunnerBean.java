package com.example.sb.runner.applicationrunner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author zkzong
 * @date 2017/11/30
 */
//@Component
public class ApplicationRunnerBean implements ApplicationRunner {
    private static final Logger logger = LoggerFactory.getLogger(ApplicationRunnerBean.class);

    @Override
    public void run(ApplicationArguments arg0) throws Exception {
        String strArgs = Arrays.stream(arg0.getSourceArgs()).collect(Collectors.joining("|"));
        logger.info("Application started with arguments:" + strArgs);
    }
}
