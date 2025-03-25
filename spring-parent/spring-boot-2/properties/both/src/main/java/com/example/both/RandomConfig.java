package com.example.both;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "user.random")
@PropertySource(value = {"classpath:config/random.properties"})
@Data
public class RandomConfig {

    private String secret;
    private int intNumber;
    private int lessTen;
    private int range;
    private long longNumber;
    private String uuid;

}
