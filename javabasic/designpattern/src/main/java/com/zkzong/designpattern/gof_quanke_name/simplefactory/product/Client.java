package com.zkzong.designpattern.gof_quanke_name.simplefactory.product;

/**
 * Created by Zong on 2016/11/23.
 */
public class Client {
    public static void main(String[] args) {
        Product product;
        product = Factory.getProduct("A"); // 通过工厂类创建产品对象
        product.methodSame();
        product.methodDiff();
    }
}
