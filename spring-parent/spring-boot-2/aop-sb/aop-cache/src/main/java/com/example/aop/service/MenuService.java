package com.example.aop.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class MenuService {

    @Cacheable(cacheNames = {"menu"})
    public List<String> getMenuList() {
        System.out.println("");
        System.out.println("mock:get from db");
        return Arrays.asList("article", "comment", "admin");
    }

}
