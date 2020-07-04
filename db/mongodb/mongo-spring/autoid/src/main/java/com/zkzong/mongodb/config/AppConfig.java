package com.zkzong.mongodb.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan({ "com.zkzong.mongodb.config", "com.zkzong.mongodb.seq", "com.zkzong.mongodb.hosting" })
@Import({ MongoConfig.class })
public class AppConfig {

}