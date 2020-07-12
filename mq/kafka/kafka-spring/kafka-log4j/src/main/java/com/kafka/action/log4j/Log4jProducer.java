package com.kafka.action.log4j;

import org.apache.log4j.Logger;

/**
 * Description:模拟生产者 <br/>
 *
 * @author moudaen
 * @version 1.0
 */
public class Log4jProducer {

    private static final Logger LOG = Logger.getLogger(Log4jProducer.class);

    public static void main(String[] args) {
        LOG.info("这是一条info级别的日志!!");
        LOG.error("这是一条error级别的日志!!");
    }
}
