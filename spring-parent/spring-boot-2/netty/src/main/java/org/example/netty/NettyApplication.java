package org.example.netty;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

/**
 * @Author: zong
 * @Date: 2020/1/13
 */
@SpringBootApplication
public class NettyApplication implements CommandLineRunner {

    @Resource
    private DiscardServer discardServer;

    public static void main(String[] args) {
        SpringApplication.run(NettyApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        discardServer.run(8080);
    }

}
