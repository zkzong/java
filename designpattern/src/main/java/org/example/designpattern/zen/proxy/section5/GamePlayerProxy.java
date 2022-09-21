package org.example.designpattern.zen.proxy.section5;

/**
 * Created by Zong on 2016/11/6.
 * 强制代理的代理类
 */
public class GamePlayerProxy implements IGamePlayer {
    private IGamePlayer gamePlayer = null;

    // 构造函数传递用户名
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

    // 代理的代理暂时还没有，就是自己
    @Override
    public IGamePlayer getProxy() {
        return this;
    }
}
