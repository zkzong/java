package com.example.aop;

import com.example.aop.bean.Product;
import com.example.aop.log.LogService;
import com.example.aop.service.ProductService;
import com.example.aop.service.sub.SubService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExecutionDemoApplicationTests {

    @Autowired
    ProductService productService;

    @Autowired
    SubService subService;

    @Autowired
    LogService logService;

    @Test
    public void test() {
        System.out.println("###begin test###");
        productService.findById(1L);
        productService.findByTwoArgs(1L, "hello");
        productService.getName();
        subService.demo();
        try {
            productService.exDemo();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        logService.log();
        productService.log();
        logService.annoArg(new Product());
    }

}
