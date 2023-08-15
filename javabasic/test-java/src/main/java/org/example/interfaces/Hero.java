package com.example.interfaces;

/**
 * Created by Zong on 2016/7/23.
 */

interface CanFight {
    void fight();
}

interface CanSwim {
    void swim();
}

interface CanFly {
    void fly();
}

class ActionCharacter {
    public void fight() {

    }
}

public class Hero extends ActionCharacter implements CanFight, CanFly, CanSwim {

    @Override
    public void swim() {

    }

    @Override
    public void fly() {

    }
}
