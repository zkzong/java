package org.example.nacos.config;

import org.apache.http.client.HttpClient;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    // 1. 使用ClientHttpRequestFactory配置RestTemplate
    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        HttpComponentsClientHttpRequestFactory httpRequestFactory = new HttpComponentsClientHttpRequestFactory(httpClient());
        httpRequestFactory.setConnectionRequestTimeout(3000);
        httpRequestFactory.setConnectTimeout(3000);
        httpRequestFactory.setReadTimeout(3000);

        return new RestTemplate(httpRequestFactory);
    }

    private HttpClient httpClient() {
        HttpRequestRetryHandler retryHandler = (exception, executionCount, context) -> {
            System.out.println("retryHandler : " + executionCount);
            if (executionCount > 3) {
                return false;
            }
            System.out.println("============");
            return true;
        };

        return HttpClientBuilder.create()
                //.setDefaultRequestConfig(requestConfig)
                //.setConnectionManager(connectionManager)
                .setConnectionManagerShared(true)
                //.setKeepAliveStrategy(strategy)
                .setRetryHandler(retryHandler)
                .build();
    }

    // 2. 使用配置文件ClientHttpRequestFactory配置RestTemplate
    @Bean
    @ConfigurationProperties(prefix = "custom.rest.connection")
    public HttpComponentsClientHttpRequestFactory customHttpRequestFactory() {
        return new HttpComponentsClientHttpRequestFactory();
    }

    @Bean
    public RestTemplate restTemplate1() {
        return new RestTemplate(customHttpRequestFactory());
    }

    // 3. 已废弃
    @Bean
    public RestTemplate restTemplate2(RestTemplateBuilder restTemplateBuilder) {
        return restTemplateBuilder
                .setConnectTimeout(3000)
                .setReadTimeout(3000)
                .build();
    }

}

