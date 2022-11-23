package org.example.nacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class NacosConsumerApplication {

    //@LoadBalanced
    //@Bean
    //public RestTemplate restTemplate() {
    //    return new RestTemplate();
    //}

    //@Bean
    //public Retryer retryer() {
    //    return new Retryer.Default(1L, 5L, 3);
    //}

    public static void main(String[] args) {
        SpringApplication.run(NacosConsumerApplication.class, args);
    }

}
