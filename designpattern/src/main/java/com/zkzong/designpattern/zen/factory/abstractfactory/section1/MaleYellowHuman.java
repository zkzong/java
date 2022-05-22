package com.zkzong.designpattern.zen.factory.abstractfactory.section1;

/**
 * Created by Zong on 2016/10/16.
 */
public class MaleYellowHuman extends AbstractYellowHuman {
    @Override
    public void getSex() {
        System.out.println("黄人男性");
    }
}
