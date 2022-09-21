package org.example.designpattern.gof_quanke_name.factorymethod.logger;

/**
 * Created by Zong on 2016/11/23.
 */
public class Client2 {
    public static void main(String[] args) {
        LoggerFactory factory;
        Logger logger;
        factory = (LoggerFactory) XMLUtil.getBean(); // getBean()的返回类型为Object，需要进行强制类型转换
        logger = factory.createLogger();
        logger.writeLog();
    }
}
