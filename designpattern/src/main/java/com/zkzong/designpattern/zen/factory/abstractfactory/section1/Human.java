package com.zkzong.designpattern.zen.factory.abstractfactory.section1;

/**
 * Created by Zong on 2016/10/16.
 */
public interface Human {
    // 每个人种都有相应的颜色
    public void getColor();

    // 人类会说话
    public void talk();

    // 每个人都有性别
    public void getSex();
}
