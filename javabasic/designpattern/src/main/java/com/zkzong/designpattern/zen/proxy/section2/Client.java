package com.zkzong.designpattern.zen.proxy.section2;

import com.zkzong.designpattern.zen.proxy.section1.GamePlayer;
import com.zkzong.designpattern.zen.proxy.section1.IGamePlayer;
import org.joda.time.DateTime;

/**
 * Created by Zong on 2016/10/28.
 */
public class Client {
    public static void main(String[] args) {
        // 定义一个痴迷的玩家
        IGamePlayer player = new GamePlayer("张三");
        // 然后再定义一个代练者
        IGamePlayer proxy = new GamePlayerProxy(player);
        // 开始打游戏，记下时间戳
        System.out.println("开始时间是：" + new DateTime().toString("yyyy-MM-dd HH:mm:ss"));
        proxy.login("zhangSan", "password");
        // 开始杀怪
        proxy.killBoss();
        // 升级
        proxy.upgrade();
        // 记录结束游戏时间
        System.out.println("结束时间是：" + new DateTime().toString("yyyy-MM-dd HH:mm:ss"));
    }
}
