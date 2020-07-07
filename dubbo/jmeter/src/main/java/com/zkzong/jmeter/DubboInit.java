package com.zkzong.jmeter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DubboInit {
    private static DubboInit init = null;

    private DubboInit() {
    }

    private static ApplicationContext context;

    public synchronized static DubboInit getInstance() {
        if (init == null) {
            init = new DubboInit();
        }
        return init;
    }

    public static void initApplicationContext() {
        context = new ClassPathXmlApplicationContext("classpath:consumer.xml");
        if (context == null) {
            throw new IllegalArgumentException("Load consumer.xml fail");
        }
    }

    public Object getBean(String beanName) {
        return context.getBean(beanName);
    }
}
