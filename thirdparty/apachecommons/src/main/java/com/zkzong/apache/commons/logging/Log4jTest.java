package com.zkzong.apache.commons.logging;

import org.apache.log4j.Logger;

/**
 * Created by Zong on 2017/2/4.
 * 需要配置log4j.properties文件
 */
public class Log4jTest {
    private static Logger log = Logger.getLogger(Log4jTest.class);

    public static void main(String[] args) {
        log.debug("Debug info.");
        log.info("Info info");
        log.warn("Warn info");
        log.error("Error info");
        log.fatal("Fatal info");
    }
}
