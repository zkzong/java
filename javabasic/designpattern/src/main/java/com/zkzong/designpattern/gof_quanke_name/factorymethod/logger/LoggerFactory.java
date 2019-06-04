package com.zkzong.designpattern.gof_quanke_name.factorymethod.logger;

/**
 * Created by Zong on 2016/11/23.
 * 日志记录器工厂接口：抽象工厂
 */
public interface LoggerFactory {
    public Logger createLogger();
}
