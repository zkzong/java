package com.example.designpattern.gof_quanke_name.factorymethod.logger3;

import com.example.designpattern.gof_quanke_name.factorymethod.logger.FileLogger;
import com.example.designpattern.gof_quanke_name.factorymethod.logger.Logger;

/**
 * Created by Zong on 2016/11/23.
 * 文件日志记录器工厂类：具体工厂
 */
public class FileLoggerFactory extends LoggerFactory {
    @Override
    public Logger createLogger() {
        // 创建文件日志记录器对象
        Logger logger = new FileLogger();
        // 创建文件，代码省略
        return logger;
    }
}
