package com.zkzong.designpattern.zen.factory.abstractfactory.section1;

/**
 * Created by Zong on 2016/10/16.
 */
public class MaleFactory implements HumanFactory {
    // 声场黄人男性
    @Override
    public Human createYellowHuman() {
        return new MaleYellowHuman();
    }

    // 声场白人男性
    @Override
    public Human createWhiteHuman() {
        return new MaleWhiteHuman();
    }

    // 声场黑人男性
    @Override
    public Human createBlackHuman() {
        return new MaleBlackHuman();
    }
}
