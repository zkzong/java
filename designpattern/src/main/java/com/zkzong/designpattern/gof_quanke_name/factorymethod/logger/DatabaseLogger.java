package com.zkzong.designpattern.gof_quanke_name.factorymethod.logger;

/**
 * Created by Zong on 2016/11/23.
 * 数据库日志记录器：具体产品
 */
public class DatabaseLogger implements Logger {
    @Override
    public void writeLog() {
        System.out.println("数据库日志记录。");
    }
}
