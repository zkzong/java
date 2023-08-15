package com.example.designpattern.zen.factory.abstractfactory.section2;

/**
 * Created by Zong on 2016/10/16.
 * 抽象产品类
 */
public abstract class AbstractProductA {
    // 每个产品共有的方法
    public void shareMethod() {
    }

    // 每个产品相同方法，不同实现
    public abstract void doSomething();
}
