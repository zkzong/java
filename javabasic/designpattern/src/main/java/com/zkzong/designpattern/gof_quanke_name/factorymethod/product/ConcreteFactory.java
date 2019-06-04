package com.zkzong.designpattern.gof_quanke_name.factorymethod.product;

/**
 * Created by Zong on 2016/11/23.
 */
public class ConcreteFactory implements Factory {
    @Override
    public Product factoryMethod() {
        return new ConcreteProduct();
    }
}
