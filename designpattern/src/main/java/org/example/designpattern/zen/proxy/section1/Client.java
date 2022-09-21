package org.example.designpattern.zen.proxy.section1;

import org.joda.time.DateTime;

/**
 * Created by Zong on 2016/10/18.
 */
public class Client {
    public static void main(String[] args) {
        IGamePlayer player = new GamePlayer("张三");
        System.out.println("开始时间是：" + new DateTime().toString("yyyy-MM-dd HH:mm:ss"));
        player.login("zhangsan", "password");
        player.killBoss();
        player.upgrade();
        System.out.println("结束时间是：" + new DateTime().toString("yyyy-MM-dd HH:mm:ss"));
    }
}
