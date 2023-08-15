package com.example.designpattern.gof_quanke_name.factorymethod.logger;

/**
 * Created by Zong on 2016/11/23.
 * 文件日志记录器：具体产品
 */
public class FileLogger implements Logger {
    @Override
    public void writeLog() {
        System.out.println("文件日志记录");
    }
}
