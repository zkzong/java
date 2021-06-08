package com.zkzong.map.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class BmwService implements CarService {
    @Override
    public BigDecimal price() {
        return new BigDecimal("150");
    }
}
