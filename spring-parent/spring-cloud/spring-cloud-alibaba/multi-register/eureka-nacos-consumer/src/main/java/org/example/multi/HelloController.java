package org.example.multi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: zong
 * @Date: 2022/1/15
 */
@RestController
public class HelloController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private RestTemplate restTemplate;

    @Resource
    private ProviderClient providerClient;

    private String serviceName = "my-provider";

    @GetMapping("/info")
    public String info() {
        List<ServiceInstance> serviceInstances = discoveryClient.getInstances(serviceName);
        StringBuilder sb = new StringBuilder();
        sb.append("All services: " + discoveryClient.getServices() + "<br/>");
        sb.append("my-provider instance list: <br/>");
        serviceInstances.forEach(instance -> {
            sb.append("[ serviceId: " + instance.getServiceId() +
                    ", host: " + instance.getHost() +
                    ", port: " + instance.getPort() + " ]");
            sb.append("<br/>");
        });
        return sb.toString();
    }

    @GetMapping("/hello")
    public String hello() {
        List<ServiceInstance> serviceInstances = discoveryClient.getInstances(serviceName);
        ServiceInstance serviceInstance = serviceInstances.stream()
                .findAny().orElseThrow(() ->
                        new IllegalStateException("no " + serviceName + " instance available"));
        return restTemplate.getForObject(
                "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() +
                        "/echo?name=nacos", String.class);
    }

    @GetMapping("/hello1")
    public String hello1() {
        String echo = providerClient.echo(null);
        return echo;
    }

}
