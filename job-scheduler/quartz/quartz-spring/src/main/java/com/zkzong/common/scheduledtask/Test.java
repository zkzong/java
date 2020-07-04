package com.zkzong.common.scheduledtask;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Zong on 2016/10/21.
 */
public class Test {
    public static void main(String[] args) {
        new ClassPathXmlApplicationContext("Spring-Quartz2.xml");
    }
}
