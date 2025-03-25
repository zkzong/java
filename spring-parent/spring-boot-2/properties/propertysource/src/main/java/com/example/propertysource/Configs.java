package com.example.propertysource;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value = {"classpath:common.properties"})
@Data
public class Configs {

    @Value("${username}")
    private String username;
    @Value("${password}")
    private String password;

}
