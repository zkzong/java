package org.example.designpattern.zen.proxy.section5;

/**
 * Created by Zong on 2016/11/6.
 * 强制代理的接口类
 */
public interface IGamePlayer {
    // 登录
    public void login(String user, String password);

    //杀怪
    public void killBoss();

    // 升级
    public void upgrade();

    // 每个人都可以找一下自己的代理
    public IGamePlayer getProxy();
}
