package com.example.designpattern.zen.proxy.section5;

import org.joda.time.DateTime;

/**
 * Created by zong on 16-11-5.
 * 直接访问代理类
 */
public class Client2 {
    public static void main(String[] args) throws Exception {
        // 定义一个游戏的角色
        IGamePlayer player = new GamePlayer("张三");
        // 然后再定义一个代练者
        IGamePlayer proxy = new GamePlayerProxy(player);
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
