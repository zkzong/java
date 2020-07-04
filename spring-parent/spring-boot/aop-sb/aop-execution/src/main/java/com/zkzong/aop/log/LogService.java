package com.zkzong.aop.log;

import com.zkzong.aop.anno.AdminOnly;
import com.zkzong.aop.bean.Product;
import org.springframework.stereotype.Component;

@Component
public class LogService implements Loggable {
    @Override
    @AdminOnly
    public void log() {
        System.out.println("log from LogService");
    }

    public void annoArg(Product product) {
        System.out.println("execute log service annoArg");
    }
}
