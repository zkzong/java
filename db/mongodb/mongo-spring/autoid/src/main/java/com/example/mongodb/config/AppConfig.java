package com.example.mongodb.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan({ "com.example.mongodb.config", "com.example.mongodb.seq", "com.example.mongodb.hosting" })
@Import({ MongoConfig.class })
public class AppConfig {

}