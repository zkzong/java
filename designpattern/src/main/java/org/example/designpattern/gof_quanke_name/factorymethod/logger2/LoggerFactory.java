package com.example.designpattern.gof_quanke_name.factorymethod.logger2;

import com.example.designpattern.gof_quanke_name.factorymethod.logger.Logger;

/**
 * Created by Zong on 2016/11/25.
 */
public interface LoggerFactory {
    public Logger createLogger();

    public Logger createLogger(String args);

    public Logger createLogger(Object obj);
}
