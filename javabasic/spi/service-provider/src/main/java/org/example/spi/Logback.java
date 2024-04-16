package org.example.spi;

/**
 * @Author: zongz
 * @Date: 2024/4/16
 */
public class Logback implements Logger {
    @Override
    public void info(String s) {
        System.out.println("Logback info 打印日志：" + s);
    }

    @Override
    public void debug(String s) {
        System.out.println("Logback debug 打印日志：" + s);
    }
}


