package org.example.designpattern.zen.proxy.section7;

import org.joda.time.DateTime;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by Zong on 2016/11/8.
 */
public class Client {
    public static void main(String[] args) {
        //定义一个玩家
        IGamePlayer player = new GamePlayer("张三");
        // 定义一个handler
        InvocationHandler handler = new GamePlayIH(player);
        // 开始打游戏，记下时间戳
        System.out.println("开始时间是：" + new DateTime().toString("yyyy-MM-dd HH:mm:ss"));
        // 获得类的ClassLoader
        ClassLoader cl = player.getClass().getClassLoader();
        // 动态产生一个代理者
        IGamePlayer proxy = (IGamePlayer) Proxy.newProxyInstance(cl, new Class[]{IGamePlayer.class}, handler);
        // 登录
        proxy.login("zhangSan", "password");
        // 杀怪
        proxy.killBoss();
        // 升级
        proxy.upgrade();
        // 记录结束游戏时间
        System.out.println("结束时间是：" + new DateTime().toString("yyyy-MM-dd HH:mm:ss"));
    }
}
