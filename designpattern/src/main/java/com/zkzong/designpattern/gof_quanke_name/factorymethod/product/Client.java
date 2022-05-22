package com.zkzong.designpattern.gof_quanke_name.factorymethod.product;

/**
 * Created by Zong on 2016/11/23.
 */
public class Client {
    public static void main(String[] args) {
        Factory factory;
        factory = new ConcreteFactory();
        Product product;
        product = factory.factoryMethod();
    }
}
