package com.example.designpattern.zen.factory.simplefactory.section1;

/**
 * Created by Zong on 2016/10/14.
 */
public class NvWa {
    public static void main(String[] args) {
        AbstractHumanFactory yinYangLu = new HumanFactory();

        System.out.println("--造出的第一批人是白色人种--");
        Human whiteHuman = yinYangLu.createHuman(WhiteHuman.class);
        whiteHuman.getColor();
        whiteHuman.talk();

        System.out.println("\n--造出的第二批人是黑色人种--");
        Human blackHuman = yinYangLu.createHuman(BlackHuman.class);
        blackHuman.getColor();
        blackHuman.talk();

        System.out.println("\n--造出的第三批人是黄色人种--");
        Human yellowHuman = yinYangLu.createHuman(YellowHuman.class);
        yellowHuman.getColor();
        yellowHuman.talk();
    }
}
