package org.example.spi;

/**
 * @Author: zongz
 * @Date: 2024/4/16
 */
public class TestJavaSPI {
    public static void main(String[] args) {
        LoggerService loggerService = LoggerService.getService();
        loggerService.info("你好");
        loggerService.debug("测试Java SPI 机制");
    }
}