package com.zkzong.designpattern.gof_quanke_name.factorymethod.logger;

/**
 * Created by Zong on 2016/11/23.
 */
public class Client {
    public static void main(String[] args) {
        LoggerFactory factory;
        Logger logger;
        factory = new FileLoggerFactory();
        logger = factory.createLogger();
        logger.writeLog();
    }
}
