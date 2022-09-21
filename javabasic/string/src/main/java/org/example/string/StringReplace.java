package org.example.string;

import org.junit.Test;

/**
 * Created by Zong on 2016/10/11.
 */
public class StringReplace {
    @Test
    public void replace() {
        String s = "[agdad]]]]";
        System.out.println(s.replace("[", "").replace("]", "")); // agdad
    }
}
