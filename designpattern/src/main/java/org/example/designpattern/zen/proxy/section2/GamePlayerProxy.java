package org.example.designpattern.zen.proxy.section2;

import org.example.designpattern.zen.proxy.section1.IGamePlayer;

/**
 * Created by Zong on 2016/10/27.
 */
public class GamePlayerProxy implements IGamePlayer {
    private IGamePlayer gamePlayer = null;

    // 通过构造函数传递要对谁进行代练
    public GamePlayerProxy(IGamePlayer _gamePlayer) {
        this.gamePlayer = _gamePlayer;
    }

    // 代练登录
    @Override
    public void login(String user, String password) {
        this.gamePlayer.login(user, password);
    }

    // 代练杀怪
    @Override
    public void killBoss() {
        this.gamePlayer.killBoss();
    }

    // 代练升级
    @Override
    public void upgrade() {
        this.gamePlayer.upgrade();
    }
}
