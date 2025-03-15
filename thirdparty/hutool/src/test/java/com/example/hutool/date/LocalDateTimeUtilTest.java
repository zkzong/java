package com.example.hutool.date;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.LocalDateTimeUtil;
import org.junit.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class LocalDateTimeUtilTest {
    @Test
    public void test() {
        // 日期转换
        String dateStr = "2020-01-23T12:23:56";
        DateTime dt = DateUtil.parse(dateStr);

        // Date对象转换为LocalDateTime
        LocalDateTime of = LocalDateTimeUtil.of(dt);

        // 时间戳转换为LocalDateTime
        of = LocalDateTimeUtil.ofUTC(dt.getTime());


        // 日期字符串解析
        // 解析ISO时间
        LocalDateTime localDateTime = LocalDateTimeUtil.parse("2020-01-23T12:23:56");

        // 解析自定义格式时间
        localDateTime = LocalDateTimeUtil.parse("2020-01-23", DatePattern.NORM_DATE_PATTERN);

        LocalDate localDate = LocalDateTimeUtil.parseDate("2020-01-23");

        // 解析日期时间为LocalDate，时间部分舍弃
        localDate = LocalDateTimeUtil.parseDate("2020-01-23T12:23:56", DateTimeFormatter.ISO_DATE_TIME);


        // 日期格式化
        localDateTime = LocalDateTimeUtil.parse("2020-01-23T12:23:56");

        // "2020-01-23 12:23:56"
        String format = LocalDateTimeUtil.format(localDateTime, DatePattern.NORM_DATETIME_PATTERN);

        // 日期偏移
        localDateTime = LocalDateTimeUtil.parse("2020-01-23T12:23:56");

        // 增加一天
        // "2020-01-24T12:23:56"
        LocalDateTime offset = LocalDateTimeUtil.offset(localDateTime, 1, ChronoUnit.DAYS);

        // "2020-01-22T12:23:56"
        offset = LocalDateTimeUtil.offset(localDateTime, -1, ChronoUnit.DAYS);


        // 计算时间间隔
        LocalDateTime start = LocalDateTimeUtil.parse("2019-02-02T00:00:00");
        LocalDateTime end = LocalDateTimeUtil.parse("2020-02-02T00:00:00");

        Duration between = LocalDateTimeUtil.between(start, end);

        // 365
        between.toDays();


        // 一天的开始和结束
        localDateTime = LocalDateTimeUtil.parse("2020-01-23T12:23:56");

        // "2020-01-23T00:00"
        LocalDateTime beginOfDay = LocalDateTimeUtil.beginOfDay(localDateTime);

        // "2020-01-23T23:59:59.999999999"
        LocalDateTime endOfDay = LocalDateTimeUtil.endOfDay(localDateTime);
    }
}
