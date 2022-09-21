package org.example.designpattern.gof_quanke_name.factorymethod.product;

/**
 * Created by Zong on 2016/11/23.
 */
public abstract class Product {
    // 所有产品类的公共业务方法
    public void methodSame() {
        // 公共方法的实现
    }

    // 声明抽象业务方法
    public abstract void methodDiff();
}
