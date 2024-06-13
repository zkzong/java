package com.example.feign.controller;

import com.example.feign.api.ProviderClient;
import com.example.feign.api.ProviderClient2;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    @Autowired
    private ProviderClient providerClient;

    @Autowired
    private ProviderClient2 providerClient2;

    @RequestMapping("/call")
    public String call() {
        return providerClient.call();
    }

    @HystrixCommand(fallbackMethod = "fallback")
    @RequestMapping("/fallbackMethod")
    public String fallbackMethod() {
        providerClient2.call();
        return "success";
    }

    public String fallback() {
        return "fallbackMethod";
    }

    /**
     * Hystrix断路器设置
     *
     * @return
     */
    @HystrixCommand(fallbackMethod = "fallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),//是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),// 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),// 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")// 失败率达到多少后跳
    })
    @RequestMapping("/circuitbreaker")
    public String circuitbreaker() {
        int i = 1 / 0;
        return "ratelimit";
    }

    /**
     * Hystrix限流
     *
     * @return
     */
    @HystrixCommand(
            groupKey = "threadA",
            threadPoolKey = "threadA",
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "20"),
                    @HystrixProperty(name = "maximumSize", value = "30"),
                    @HystrixProperty(name = "maxQueueSize", value = "20"),
                    @HystrixProperty(name = "keepAliveTimeMinutes", value = "2")
            }, commandProperties = {
            @HystrixProperty(name = "execution.isolation.strategy", value = "THREAD")
    })
    @RequestMapping("/ratelimit")
    public String ratelimit() {
        return "ratelimit";
    }
}
