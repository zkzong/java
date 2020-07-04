package com.atguigu.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 监听项目的启动和停止
 *
 * @Author: zkzong
 * @Date: 2019/10/19
 */
public class UserListener implements ServletContextListener {

    // 监听ServletContext启动初始化
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();
        System.out.println("UserListener...contextInitialized...");
    }

    // 监听ServletContext销毁
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("UserListener...contextDestroyed...");
    }
}
