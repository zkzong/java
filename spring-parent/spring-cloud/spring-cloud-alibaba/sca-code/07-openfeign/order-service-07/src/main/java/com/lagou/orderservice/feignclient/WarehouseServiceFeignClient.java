package com.lagou.orderservice.feignclient;

import com.lagou.orderservice.dto.Stock;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("warehouse-service")
public interface WarehouseServiceFeignClient {
    @GetMapping("/stock")
    public Stock getStock(@RequestParam("skuId") Long skuId);

}
