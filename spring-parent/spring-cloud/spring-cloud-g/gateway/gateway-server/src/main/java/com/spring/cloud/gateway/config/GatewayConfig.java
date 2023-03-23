package com.spring.cloud.gateway.config;

import com.spring.cloud.gateway.filter.DecryptRequestBodyGatewayFilterFactory;
import com.spring.cloud.gateway.filter.EncryptResponseBodyGatewayFilterFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    /**
     * 注入自定义授权网关过滤器工厂
     */
    //@Bean
    //public AuthGatewayFilterFactory authGatewayFilterFactory() {
    //    return new AuthGatewayFilterFactory();
    //}

    /**
     * request body解密
     */
    @Bean
    public DecryptRequestBodyGatewayFilterFactory decryptRequestBodyGatewayFilterFactory() {
        return new DecryptRequestBodyGatewayFilterFactory();
    }

    /**
     * response body加密
     */
    @Bean
    public EncryptResponseBodyGatewayFilterFactory encryptResponseBodyGatewayFilterFactory() {
        return new EncryptResponseBodyGatewayFilterFactory();
    }

}
