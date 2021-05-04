package com.lagou.warehouseservice.dubbo;

import com.lagou.warehouseservice.dto.Stock;

public interface WarehouseService {
    public Stock getStock(Long skuId);
}
