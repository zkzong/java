package org.example.designpattern.gof_quanke_name.factorymethod.logger3;

/**
 * Created by Zong on 2016/11/25.
 */
public class Client {
    public static void main(String[] args) {
        LoggerFactory factory;
        factory = (LoggerFactory) XMLUtil.getBean();
        factory.writeLog();
    }

}
