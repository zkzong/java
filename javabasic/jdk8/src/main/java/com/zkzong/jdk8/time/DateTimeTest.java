package com.zkzong.jdk8.time;

import org.junit.Test;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.MonthDay;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

public class DateTimeTest {

    @Test
    public void localDate() {
        LocalDate localDate = LocalDate.now();
        System.out.println("localDate : " + localDate); // localDate : 2017-08-24

        // 指定特定日期：of parse
        System.out.println(LocalDate.of(2017, 8, 24)); // 2017-08-24
        System.out.println(LocalDate.parse("2017-08-24")); // 2017-08-24

        // 添加一天
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        System.out.println(tomorrow); // 2017-08-25

        LocalDate tm = LocalDate.now().plus(1, ChronoUnit.DAYS);
        System.out.println(tm); // 2017-08-25

        // 减去一个月
        LocalDate prevMonth = LocalDate.now().minus(1, ChronoUnit.MONTHS);
        System.out.println(prevMonth); // 2017-07-25

        // 获取某天是周几或是几号
        DayOfWeek friday = LocalDate.parse("2017-08-25").getDayOfWeek();
        System.out.println("今天是周几：" + friday); // FRIDAY
        int day = LocalDate.parse("2017-08-25").getDayOfMonth();
        System.out.println("今天是几号：" + day); // 25

        // 是否闰年
        boolean leapYear = LocalDate.now().isLeapYear();
        System.out.println("是否闰年：" + leapYear); // false

        // 是否在日期之前或之后
        boolean notBefore = LocalDate.parse("2017-08-25").isBefore(LocalDate.parse("2017-08-23"));
        System.out.println("notBefore：" + notBefore); // false
        boolean isAfter = LocalDate.parse("2017-08-25").isAfter(LocalDate.parse("2017-08-23"));
        System.out.println("isAfter：" + isAfter); // true

        // 获取这个月的第一天
        LocalDate firstDayOfMonth = LocalDate.parse("2017-08-25").with(TemporalAdjusters.firstDayOfMonth());
        System.out.println("这个月的第一天：" + firstDayOfMonth); // 2017-08-01
        firstDayOfMonth = firstDayOfMonth.withDayOfMonth(1);
        System.out.println("这个月的第一天：" + firstDayOfMonth); // 2017-08-01

        LocalDate birthday = LocalDate.of(2017, 8, 25);
        MonthDay birthdayMd = MonthDay.of(birthday.getMonth(), birthday.getDayOfMonth());
        MonthDay today = MonthDay.from(LocalDate.now());
        System.out.println("今天是否是我的生日：" + today.equals(birthdayMd)); // true

    }

    @Test
    public void localTime() {
        // 获取现在的时间
        LocalTime now = LocalTime.now();
        System.out.println("现在的时间：" + now); // 11:42:21.323

        // 将一个字符串解析为LocalTime
        LocalTime nowTime = LocalTime.parse("15:02");
        System.out.println("时间是：" + nowTime); // 15:02

        LocalTime nowTimeof = LocalTime.of(15, 02);
        System.out.println("时间是：" + nowTimeof); // 15:02

        // 下一小时
        LocalTime nextHour = LocalTime.parse("15:02").plus(1, ChronoUnit.HOURS);
        System.out.println("下一个小时：" + nextHour); // 16:02

        // 获取时间的小时、分钟
        int hour = LocalTime.parse("15:02").getHour();
        System.out.println("小时：" + hour); // 15
        int minute = LocalTime.parse("15:02").getMinute();
        System.out.println("分钟：" + minute); // 02

        boolean isBefore = LocalTime.parse("15:02").isBefore(LocalTime.parse("16:02"));
        boolean isAfter = LocalTime.parse("15:02").isAfter(LocalTime.parse("16:02"));
        System.out.println("isBefore: " + isBefore); // true
        System.out.println("isAfter: " + isAfter); // false

        System.out.println(LocalTime.MAX); // 23:59:59.999999999
        System.out.println(LocalTime.MIN); // 00:00
    }

    @Test
    public void localDateTime() {
        // 获取当前的日期和时间
        LocalDateTime now = LocalDateTime.now();
        System.out.println("现在：" + now); // 2017-08-25T13:42:54.578

        // 字符串创建LocalDateTime对象
        LocalDateTime.of(2017, Month.JULY, 20, 15, 18);
        LocalDateTime.parse("2017-07-20T15:18:00");

        // 增减操作
        LocalDateTime tomorrow = now.plusDays(1);
        System.out.println("明天的这个时间: " + tomorrow);
        LocalDateTime minusTowHour = now.minusHours(2);
        System.out.println("两小时前: " + minusTowHour);

        // 获取特定单位
        Month month = now.getMonth();
        System.out.println("当前月份: " + month);
    }

    @Test
    public void format() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println("默认格式化：" + now); // 2017-08-25T13:49:53.939
        System.out.println("自定义格式化：" + now.format(dateTimeFormatter)); // 2017-08-25 13:49:53
        LocalDateTime localDateTime = LocalDateTime.parse("2017-08-25 13:51:23", dateTimeFormatter);
        System.out.println("字符串转LocalDateTime：" + localDateTime); // 2017-08-25T13:51:23

        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String dateString = dateTimeFormatter1.format(LocalDate.now());
        System.out.println("日期字符串：" + dateString); // 2017-08-25
    }

    @Test
    public void period() {
        LocalDate initialDate = LocalDate.parse("2017-08-25");
        LocalDate finalDate = initialDate.plus(Period.ofDays(5));
        System.out.println("初始化日期：" + initialDate); // 2017-08-25
        System.out.println("加日期之后：" + finalDate); // 2017-08-30

        long between = ChronoUnit.DAYS.between(initialDate, finalDate);
        System.out.println("差距天数：" + between); // 5
    }

    @Test
    public void convert() {
        // Date和Instant互相转换
        Date date = Date.from(Instant.now());
        Instant instant = date.toInstant();

        LocalDateTime localDateTime = null;
        // Date转换为LocalDateTime
//        localDateTime = LocalDateTime.from(new Date());
//        System.out.println(localDateTime);

        // LocalDateTime转Date
        Date date1 = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());

        // LocalDate转Date
        Date date2 = Date.from(LocalDate.now().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }
}
