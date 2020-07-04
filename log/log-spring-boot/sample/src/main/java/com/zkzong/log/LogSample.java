package com.zkzong.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: Zong
 * @Date: 2018/9/17
 */
public class LogSample {
    final Logger logger = LoggerFactory.getLogger(LogSample.class);

    public static void main(String[] args) {
        LogSample logSample = new LogSample();
        logSample.test();

        System.out.println("Hello World!");
    }

    private void test() {
        logger.info("这是一条日志信息 - {}", "zong");
    }
}
