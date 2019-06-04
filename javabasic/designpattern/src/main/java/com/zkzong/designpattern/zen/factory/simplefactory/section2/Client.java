package com.zkzong.designpattern.zen.factory.simplefactory.section2;

/**
 * Created by Zong on 2016/10/14.
 */
public class Client {
    public static void main(String[] args) {
        Creator creator = new ConcreteCreator();
        Product product = creator.createProduct(ConcreteProduct1.class);
        /*
         * 继续业务处理
         */
    }
}
