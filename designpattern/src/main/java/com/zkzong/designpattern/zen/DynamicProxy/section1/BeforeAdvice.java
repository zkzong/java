package com.zkzong.designpattern.zen.DynamicProxy.section1;

/**
 * Created by Zong on 2016/11/9.
 */
public class BeforeAdvice implements IAdvice {
    @Override
    public void exec() {
        System.out.println("我是前置通知，我被执行了！");
    }
}
