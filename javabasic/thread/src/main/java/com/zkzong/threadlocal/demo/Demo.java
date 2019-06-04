package com.zkzong.threadlocal.demo;

import org.junit.Test;

public class Demo {

    @Test
    public void test1() {
        ProductService productService = new ProductServiceImpl();
        productService.updateProductPrice(1, 3000);
    }

    @Test
    public void test2() {
        for (int i = 0; i < 10; i++) {
            ProductService productService = new ProductServiceImpl();
            productService.updateProductPrice(1, 3000);
            ClientThread thread = new ClientThread(productService);
            thread.start();
        }
    }
}
