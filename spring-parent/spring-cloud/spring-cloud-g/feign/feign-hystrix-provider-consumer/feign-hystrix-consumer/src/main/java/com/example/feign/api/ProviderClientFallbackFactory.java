package com.example.feign.api;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class ProviderClientFallbackFactory implements FallbackFactory<ProviderClient> {

    @Override
    public ProviderClient create(Throwable throwable) {
        return new ProviderClient() {
            @Override
            public String call() {
                return "fallbackFactory fail";
            }
        };
    }
}
