package com.zkzong.designpattern.zen.proxy.section3;

/**
 * Created by Zong on 2016/10/28.
 * 代理类
 */
public class Proxy implements Subject {
    // 要代理哪个实现类
    private Subject subject = null;

    // 默认被代理者
    public Proxy() {
        this.subject = new Proxy();
    }

    public Proxy(Subject _subject) {
        this.subject = _subject;
    }

    // 通过构造函数传递代理者
    public Proxy(Object... objects) {
    }

    // 实现接口中定义的方法
    @Override
    public void request() {
        this.before();
        this.subject.request();
        this.after();
    }

    // 预处理
    private void before() {
    }

    // 善后处理
    private void after() {
    }
}
