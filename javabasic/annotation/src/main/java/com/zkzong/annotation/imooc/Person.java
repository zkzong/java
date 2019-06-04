package com.zkzong.annotation.imooc;

@Description("I am interface")
public interface Person {
    @Description("I am interface method")
    String name();

    int age();

    @Deprecated
    void sing();
}
