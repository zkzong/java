package org.example.aop.log;

import org.example.aop.anno.AdminOnly;
import org.example.aop.bean.Product;
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
