package org.example.map.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AudiService implements CarService {
    @Override
    public BigDecimal price() {
        return new BigDecimal("100");
    }
}
