package com.zkzong.thinkinginjava.generics;

import com.zkzong.thinkinginjava.generics.watercolors.Watercolors;

import java.util.EnumSet;
import java.util.Set;

import static com.zkzong.thinkinginjava.generics.watercolors.Watercolors.BRILLIANT_RED;
import static com.zkzong.thinkinginjava.generics.watercolors.Watercolors.BURNT_UMBER;
import static com.zkzong.thinkinginjava.generics.watercolors.Watercolors.CERULEAN_BLUE_HUE;
import static com.zkzong.thinkinginjava.generics.watercolors.Watercolors.VIRIDIAN_HUE;
import static com.zkzong.thinkinginjava.util.Print.print;
import static com.zkzong.thinkinginjava.util.Sets.complement;
import static com.zkzong.thinkinginjava.util.Sets.difference;
import static com.zkzong.thinkinginjava.util.Sets.intersection;
import static com.zkzong.thinkinginjava.util.Sets.union;

/**
 * Created by Zong on 2016/8/31.
 */
public class WatercolorSets {
    public static void main(String[] args) {
        Set<Watercolors> set1 = EnumSet.range(BRILLIANT_RED, VIRIDIAN_HUE);
        Set<Watercolors> set2 = EnumSet.range(CERULEAN_BLUE_HUE, BURNT_UMBER);
        print("set1: " + set1);
        print("set2: " + set2);
        print("union(set1, set2): " + union(set1, set2));

        Set<Watercolors> subset = intersection(set1, set2);
        print("intersection(set1, set2): " + subset);
        print("difference(set1, subset): " + difference(set2, subset));
        print("complement(set1, set2): " + complement(set1, set2));
    }
}
