package org.example.aop.service;

import org.example.aop.domain.Product;
import org.example.aop.security.AdminOnly;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private AuthService authService;

    @AdminOnly
    public void insert(Product product) {
        //authService.checkAccess();
        System.out.println("insert product");
    }

    @AdminOnly
    public void delete(Long id) {
        //authService.checkAccess();
        System.out.println("delete product");
    }
}
