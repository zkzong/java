package com.zkzong.job;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {

    private static final int EMBED_ZOOKEEPER_PORT = 2181;

    public static void main(String[] args) {
//        EmbedZookeeperServer.start(EMBED_ZOOKEEPER_PORT);
        new ClassPathXmlApplicationContext("applicationContext.xml");
    }
}
