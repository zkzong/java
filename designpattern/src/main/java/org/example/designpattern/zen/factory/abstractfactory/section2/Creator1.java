package com.example.designpattern.zen.factory.abstractfactory.section2;

/**
 * Created by Zong on 2016/10/16.
 * 产品等级1的实现类
 */
public class Creator1 extends AbstractCreator {
    // 只生产产品等级为1的A产品
    @Override
    public AbstractProductA createProductA() {
        return new ProductA1();
    }

    // 只生产产品等级为1的B产品
    @Override
    public AbstractProductB createProductB() {
        return new ProductB1();
    }
}
