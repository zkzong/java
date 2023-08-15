package com.example.multi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.serviceregistry.AutoServiceRegistrationProperties;

@SpringBootApplication
@EnableConfigurationProperties(AutoServiceRegistrationProperties.class)
public class EurekaNacosProvider {

    public static void main(String[] args) {
        SpringApplication.run(EurekaNacosProvider.class, args);
    }

}
