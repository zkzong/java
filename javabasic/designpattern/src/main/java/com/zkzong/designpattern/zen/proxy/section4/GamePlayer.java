package com.zkzong.designpattern.zen.proxy.section4;

import com.zkzong.designpattern.zen.proxy.section1.IGamePlayer;

/**
 * Created by Zong on 2016/11/4.
 * 普通代理的游戏者
 */
public class GamePlayer implements IGamePlayer {
    private String name = "";

    public GamePlayer(IGamePlayer _gamePlayer, String _name) throws Exception {
        if (_gamePlayer == null) {
            throw new Exception("不能创建真实角色！");
        } else {
            this.name = _name;
        }
    }

    // 进游戏之前肯定要登录，这是一个必要条件
    @Override
    public void login(String user, String password) {
        System.out.println("登录名为" + user + "的用户" + this.name + "登录成功！");
    }

    // 打怪
    @Override
    public void killBoss() {
        System.out.println(this.name + "在打怪！");
    }

    // 升级
    @Override
    public void upgrade() {
        System.out.println(this.name + " 又升了一级！");
    }
}
