package org.example.designpattern.gof_quanke_name.abstractfactory.skin;

/**
 * Created by Zong on 2016/11/23.
 * Summer按钮类：具体产品
 */
public class SummerButton implements Button {
    @Override
    public void display() {
        System.out.println("显示浅蓝色按钮。");
    }
}
