package com.zkzong.override;

/**
 * Created by Zong on 2016/12/4.
 */
class Base {
}

class Agg extends Base {
    public String getFields() {
        String name = "Agg";
        return name;
    }
}

public class Avf {
    public static void main(String[] args) {
        Base a = new Agg();
        System.out.println(((Agg) a).getFields());
//        System.out.println(a.getFields()); // 编译错误，父类中无此方法
    }
}
