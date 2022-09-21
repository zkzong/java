package org.example.quartz.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Zong on 2016/9/26.
 */
public class App {
    public static void main(String[] args) {
        new ClassPathXmlApplicationContext("Spring-Quartz.xml");
    }
}
