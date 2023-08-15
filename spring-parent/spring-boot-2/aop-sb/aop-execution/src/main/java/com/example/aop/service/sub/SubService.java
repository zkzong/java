package com.example.aop.service.sub;

import com.example.aop.service.ProductService;
import org.springframework.stereotype.Component;

@Component
public class SubService extends ProductService {

    public void demo() {
        System.out.println("execute sub service method");
    }
}
