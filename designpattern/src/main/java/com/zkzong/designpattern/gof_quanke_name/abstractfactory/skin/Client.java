package com.zkzong.designpattern.gof_quanke_name.abstractfactory.skin;

/**
 * Created by Zong on 2016/11/23.
 */
public class Client {
    public static void main(String[] args) {
        SkinFactory factory;
        Button bt;
        TextField tf;
        ComboBox cb;
        factory = new SpringSkinFactory();
        bt = factory.createButton();
        tf = factory.createTextField();
        cb = factory.createComboBox();
        bt.display();
        tf.display();
        cb.display();
    }
}
