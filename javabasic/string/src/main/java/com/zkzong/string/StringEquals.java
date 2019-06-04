package com.zkzong.string;

import org.junit.Test;

/**
 * Created by Zong on 2017/2/4.
 */
public class StringEquals {
    @Test
    public void equals() {
        String get = "get";
        String GET = "GET";

        System.out.println(get.equals(GET)); // false
        System.out.println(get.equalsIgnoreCase(GET)); // true

    }
}
