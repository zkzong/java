package com.example.thinkinginjava.generics;

import com.example.thinkinginjava.generics.watercolors.Watercolors;

import java.util.EnumSet;
import java.util.Set;

import static com.example.thinkinginjava.util.Print.print;
import static com.example.thinkinginjava.util.Sets.complement;
import static com.example.thinkinginjava.util.Sets.difference;
import static com.example.thinkinginjava.util.Sets.intersection;
import static com.example.thinkinginjava.util.Sets.union;

/**
 * Created by Zong on 2016/8/31.
 */
public class WatercolorSets {
    public static void main(String[] args) {
        Set<Watercolors> set1 = EnumSet.range(Watercolors.BRILLIANT_RED, Watercolors.VIRIDIAN_HUE);
        Set<Watercolors> set2 = EnumSet.range(Watercolors.CERULEAN_BLUE_HUE, Watercolors.BURNT_UMBER);
        print("set1: " + set1);
        print("set2: " + set2);
        print("union(set1, set2): " + union(set1, set2));

        Set<Watercolors> subset = intersection(set1, set2);
        print("intersection(set1, set2): " + subset);
        print("difference(set1, subset): " + difference(set2, subset));
        print("complement(set1, set2): " + complement(set1, set2));
    }
}
