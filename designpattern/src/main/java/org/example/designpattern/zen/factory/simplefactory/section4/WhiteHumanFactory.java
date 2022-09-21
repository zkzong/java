package org.example.designpattern.zen.factory.simplefactory.section4;

/**
 * Created by Zong on 2016/10/15.
 */
public class WhiteHumanFactory extends AbstractHumanFactory {
    @Override
    public Human createHuman() {
        return new WhiteHuman();
    }
}
