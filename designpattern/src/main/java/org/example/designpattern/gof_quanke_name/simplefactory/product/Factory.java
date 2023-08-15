package com.example.designpattern.gof_quanke_name.simplefactory.product;

/**
 * Created by Zong on 2016/11/23.
 */
public class Factory {
    // 静态工厂方法
    public static Product getProduct(String arg) {
        Product product = null;
        if (arg.equalsIgnoreCase("A")) {
            product = new ConcreteProductA();
            // 初始化设置product
        } else if (arg.equalsIgnoreCase("B")) {
            product = new ConcreteProductB();
            // 初始化设置product
        }
        return product;
    }
}
