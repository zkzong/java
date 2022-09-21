package org.example.mongodb.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan({ "org.example.mongodb.config", "org.example.mongodb.seq", "org.example.mongodb.hosting" })
@Import({ MongoConfig.class })
public class AppConfig {

}