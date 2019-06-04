package com.zkzong.designpattern.gof_quanke_name.factorymethod.logger3;

import com.zkzong.designpattern.gof_quanke_name.factorymethod.logger.Logger;

/**
 * Created by Zong on 2016/11/25.
 */
public abstract class LoggerFactory {
    public abstract Logger createLogger();

    // 在工厂类中直接调用日志记录器类的业务方法writeLog()
    public void writeLog() {
        Logger logger = this.createLogger();
        logger.writeLog();
    }
}
