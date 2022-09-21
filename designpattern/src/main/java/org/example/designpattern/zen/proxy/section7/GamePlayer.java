package org.example.designpattern.zen.proxy.section7;


/**
 * Created by Zong on 2016/11/8.
 */
public class GamePlayer implements IGamePlayer {
    private String name = "";

    //通过构造函数传递名称
    public GamePlayer(String _name) {
        this.name = _name;
    }

    @Override
    public void login(String user, String password) {
        System.out.println("登录名为" + user + " 的用户 " + this.name + "登录成功！");
    }

    @Override
    public void killBoss() {
        System.out.println(this.name + "在打怪！");
    }

    @Override
    public void upgrade() {
        System.out.println(this.name + " 又升了一级！");
    }
}
