package org.example.nacos.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    // 1.
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
        return restTemplateBuilder
                .setConnectTimeout(3000)
           .setReadTimeout(3000)
           .build();
    }

    @Bean
    public RestTemplate restTemplate(@Qualifier("simpleClientHttpRequestFactory") SimpleClientHttpRequestFactory factory) {
        return new RestTemplate(factory);
    }

    @Bean
    public SimpleClientHttpRequestFactory simpleClientHttpRequestFactory() {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setConnectTimeout(2000); // 毫秒
        factory.setReadTimeout(10000); // 毫秒
        return factory;
    }
}

