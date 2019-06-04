package com.zkzong.jdk8.time;

import org.junit.Test;

import java.time.Instant;

/**
 * Created by zong on 2017/2/12.
 */
public class InstantTest {
    @Test
    public void testInstant() {
        // 当前时间
        System.out.println(Instant.now()); // 2017-02-12T07:24:05.247Z

        // 当前秒数，从1970-01-01T00:00:00Z开始计算
        System.out.println(Instant.now().getEpochSecond()); // 1486884245
    }
}
