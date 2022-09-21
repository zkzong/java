package org.example.http.util.cm;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @Author: zong
 * @Date: 2019.1.18
 */
@Component
@Configuration
public class HttpClientManager {
    @Bean(name = "poolingHttpClientConnectionManager")
    public PoolingHttpClientConnectionManager poolingHttpClientConnectionManager() {
        PoolingHttpClientConnectionManager poolingHttpClientConnectionManager = new PoolingHttpClientConnectionManager();
        poolingHttpClientConnectionManager.setMaxTotal(200);
        poolingHttpClientConnectionManager.setDefaultMaxPerRoute(50);
        return poolingHttpClientConnectionManager;
    }

    @Bean(name = "httpClientBuilder")
    public HttpClientBuilder httpClientBuilder() {
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        httpClientBuilder.setConnectionManager(poolingHttpClientConnectionManager());
        return httpClientBuilder;
    }

    @Bean(name = "httpClient")
    public CloseableHttpClient httpClient() {
        return httpClientBuilder().build();
    }

}
