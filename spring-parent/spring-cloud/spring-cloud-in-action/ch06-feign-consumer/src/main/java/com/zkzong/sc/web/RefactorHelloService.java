package com.zkzong.sc.web;

import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * Created by zong on 2017/7/10.
 */
@FeignClient(value = "HELLO-SERVICE")
public interface RefactorHelloService extends com.zkzong.sc.service.HelloService {

}
