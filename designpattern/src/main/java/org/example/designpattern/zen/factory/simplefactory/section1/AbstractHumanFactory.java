package com.example.designpattern.zen.factory.simplefactory.section1;

/**
 * Created by Zong on 2016/10/14.
 */
public abstract class AbstractHumanFactory {
    public abstract <T extends Human> T createHuman(Class<T> c);
}
