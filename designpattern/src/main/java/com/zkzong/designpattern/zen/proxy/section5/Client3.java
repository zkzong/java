package com.zkzong.designpattern.zen.proxy.section5;

import org.joda.time.DateTime;

/**
 * Created by Zong on 2016/11/7.
 */
public class Client3 {
    public static void main(String[] args) {
        // 定义一个游戏的角色
        IGamePlayer player = new GamePlayer("张三");
        // 获得指定的代理
        IGamePlayer proxy = player.getProxy();
        // 开始打游戏，记下时间戳
        System.out.println("开始时间是：" + new DateTime().toString("yyyy-MM-dd HH:mm:ss"));
        proxy.login("zhangSan", "password");
        // 杀怪
        proxy.killBoss();
        // 升级
        proxy.upgrade();
        // 记录结束游戏时间
        System.out.println("结束时间是：" + new DateTime().toString("yyyy-MM-dd HH:mm:ss"));
    }
}
