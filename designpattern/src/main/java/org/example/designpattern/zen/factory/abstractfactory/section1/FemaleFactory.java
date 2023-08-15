package com.example.designpattern.zen.factory.abstractfactory.section1;

/**
 * Created by Zong on 2016/10/16.
 */
public class FemaleFactory implements HumanFactory {
    // 声场黄人女性
    @Override
    public Human createYellowHuman() {
        return new FemaleYellowHuman();
    }

    // 声场白人女性
    @Override
    public Human createWhiteHuman() {
        return new FemaleWhiteHuman();
    }

    // 声场黑人女性
    @Override
    public Human createBlackHuman() {
        return new FemaleBlackHuman();
    }
}
