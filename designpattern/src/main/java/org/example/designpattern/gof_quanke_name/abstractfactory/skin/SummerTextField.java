package org.example.designpattern.gof_quanke_name.abstractfactory.skin;

/**
 * Created by Zong on 2016/11/23.
 * Summer文本框类：具体产品
 */
public class SummerTextField implements TextField {
    @Override
    public void display() {
        System.out.println("显示蓝色边框文本框。");
    }
}
