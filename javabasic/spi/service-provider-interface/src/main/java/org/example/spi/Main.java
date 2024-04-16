package org.example.spi;

/**
 * @Author: zongz
 * @Date: 2024/4/16
 */
public class Main {
    public static void main(String[] args) {
        LoggerService service = LoggerService.getService();

        service.info("Hello SPI");
        service.debug("Hello SPI");
    }
}

