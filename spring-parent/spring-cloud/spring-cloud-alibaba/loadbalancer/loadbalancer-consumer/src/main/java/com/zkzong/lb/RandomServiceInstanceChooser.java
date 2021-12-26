package com.zkzong.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.ServiceInstanceChooser;

import java.util.List;
import java.util.Random;

public class RandomServiceInstanceChooser implements ServiceInstanceChooser {

    private final DiscoveryClient discoveryClient;

    private final Random random;

    public RandomServiceInstanceChooser(DiscoveryClient discoveryClient) {
        this.discoveryClient = discoveryClient;
        random = new Random();
    }

    @Override
    public ServiceInstance choose(String serviceId) {
        List<ServiceInstance> serviceInstanceList = discoveryClient.getInstances(serviceId);
        return serviceInstanceList.get(random.nextInt(serviceInstanceList.size()));
    }
}
