package com.zkzong.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: zong
 * @Date: 2019.1.11
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("aop.xml");
        Run run = (Run) context.getBean("run");
        System.out.println(run);
        int result = 0;
        result = run.add(1, 2);
        System.out.println(result);
        result = run.div(10, 2);
        System.out.println(result);
    }
}
