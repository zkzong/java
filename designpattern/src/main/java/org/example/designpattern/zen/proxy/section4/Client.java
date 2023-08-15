package com.example.designpattern.zen.proxy.section4;

import com.example.designpattern.zen.proxy.section1.IGamePlayer;
import org.joda.time.DateTime;

/**
 * Created by zong on 16-11-5.
 */
public class Client {
    public static void main(String[] args) throws Exception {
        // 定义一个代练者
        IGamePlayer proxy = new GamePlayerProxy("张三");
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
