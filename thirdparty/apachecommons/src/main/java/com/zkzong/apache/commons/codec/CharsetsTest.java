package com.zkzong.apache.commons.codec;

import org.apache.commons.codec.Charsets;
import org.junit.Test;

import java.nio.charset.StandardCharsets;

/**
 * Created by Zong on 2017/5/18.
 */
public class CharsetsTest {
    @Test
    public void testCharsets() {
        System.out.println(Charsets.UTF_8);
        System.out.println(StandardCharsets.UTF_8);
    }
}
