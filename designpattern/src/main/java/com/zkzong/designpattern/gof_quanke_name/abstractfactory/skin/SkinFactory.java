package com.zkzong.designpattern.gof_quanke_name.abstractfactory.skin;

/**
 * Created by Zong on 2016/11/23.
 * 界面皮肤工厂接口：抽象工厂
 */
public interface SkinFactory {
    public Button createButton();

    public TextField createTextField();

    public ComboBox createComboBox();
}
