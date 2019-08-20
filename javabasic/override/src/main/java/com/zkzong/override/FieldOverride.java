package com.zkzong.override;

class Super {
    String s = "Super";
}

class Sub extends Super {
    String s = "Sub";
}

public class FieldOverride {
    public static void main(String[] args) {
        Sub c1 = new Sub();
        System.out.println(c1.s);
        Super c2 = new Sub();
        System.out.println(c2.s);
        /**
         * Sub
         * Super
         */
        // 在类中，与父类中的字段具有相同名称的字段为隐藏字段，即使它们的类型不同。
        // 该字段必须通过父类访问。
        // 成员字段不能像方法一样被重写。
    }
}

