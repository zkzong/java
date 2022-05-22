package com.zkzong.designpattern.gof_quanke_name.factorymethod.logger3;

import com.zkzong.designpattern.gof_quanke_name.factorymethod.logger.DatabaseLogger;
import com.zkzong.designpattern.gof_quanke_name.factorymethod.logger.Logger;

/**
 * Created by Zong on 2016/11/23.
 * 数据库日志记录器工厂类：具体工厂
 */
public class DatabaseLoggerFactory extends LoggerFactory {
    @Override
    public Logger createLogger() {
        // 连接数据库，代码省略
        // 创建数据库日志记录器对象
        Logger logger = new DatabaseLogger();
        // 初始化数据库日志记录器，代码省略
        return logger;
    }
}
