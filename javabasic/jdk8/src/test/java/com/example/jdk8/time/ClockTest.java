package com.example.jdk8.time;

import org.junit.Test;

import java.time.Clock;
import java.time.Instant;
import java.util.Date;

/**
 * Created by zong on 2017/2/12.
 */
public class ClockTest {
    @Test
    public void testClock() {
        Clock clock = Clock.systemDefaultZone();
        // 取代System.currentTimeMillis()
        long millis = clock.millis();
        System.out.println(millis);

        // 使用Instant创建Date
        Instant instant = clock.instant();
        Date date = Date.from(instant);
        System.out.println(date);
    }
}
