package com.zkzong.apache.commons.logging;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Created by Zong on 2017/2/4.
 */
public class LogTest {
    private static Log log = LogFactory.getLog(LogTest.class);

    public static void main(String[] args) {
        log.error("ERROR");
        log.debug("DEBUG");
        log.warn("WARN");
        log.info("INFO");
        log.trace("TRACE");
        System.out.println(log.getClass());
    }
}
