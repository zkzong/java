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
    }
}

