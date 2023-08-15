package com.example.lb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient(autoRegister = false)
//@LoadBalancerClients(defaultConfiguration = MyLoadBalancerConfiguration.class)
public class NacosConsumer4SCLB {

    public static void main(String[] args) {
        SpringApplication.run(NacosConsumer4SCLB.class, args);
    }

    @Configuration
    @LoadBalancerClient(name = "nacos-provider-lb", configuration = MyLoadBalancerConfiguration.class)
    class LoadBalanceConfiguration {

    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public RestTemplate normalRestTemplate() {
        return new RestTemplate();
    }

    @Bean
    public RandomServiceInstanceChooser randomServiceInstanceChooser(DiscoveryClient discoveryClient) {
        return new RandomServiceInstanceChooser(discoveryClient);
    }

    @RestController
    class HelloController {

        @Autowired
        private RestTemplate restTemplate;

        @Autowired
        private RestTemplate normalRestTemplate;

        @Autowired
        private RandomServiceInstanceChooser randomServiceInstanceChooser;

        private String serviceName = "nacos-provider-lb";

        @GetMapping("/echo")
        public String echo() {
            return restTemplate.getForObject("http://" + serviceName + "/", String.class);
        }

        @GetMapping("/customChooser")
        public String customChooser() {
            ServiceInstance serviceInstance = randomServiceInstanceChooser.choose(serviceName);
            return normalRestTemplate.getForObject(
                    "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/", String.class);
        }

    }

}
