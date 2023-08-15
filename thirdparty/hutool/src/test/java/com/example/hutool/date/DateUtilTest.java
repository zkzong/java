package com.example.hutool.date;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: zong
 * @Date: 2021/9/27
 */
public class DateUtilTest {

    @Test
    public void date() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        // between
        final long between = DateUtil.between(sdf.parse("2021-09-25 20:00:00"), new Date(), DateUnit.DAY);
        System.out.println("相隔天数：" + between);

        // compare
        final long compare = DateUtil.compare(sdf.parse("2021-09-25 20:00:00"), new Date());
        System.out.println("日期比较：" + compare);

        // yesterday
        final Date date = DateUtil.yesterday().toJdkDate();
        System.out.println("昨天：" + date);

        // tomorrow
        final Date tomorrow = DateUtil.tomorrow().toJdkDate();
        System.out.println("明天：" + tomorrow);

        // 下一天
        DateTime nextDay = DateUtil.offsetDay(new Date(), 1);
        System.out.println("下一天：" + nextDay);

        DateTime beginOfDay = DateUtil.beginOfDay(new Date());
        System.out.println("当天开始时间：" + beginOfDay);

        // 月初/月末
        DateTime beginOfMonth = DateUtil.beginOfMonth(new Date());
        System.out.println("月初：" + beginOfMonth);
        DateTime endOfMonth = DateUtil.endOfMonth(new Date());
        System.out.println("月末：" + endOfMonth);

        // 下个月月初
        DateTime dateTime = DateUtil.nextMonth();
        System.out.println("下个月：" + dateTime);
        DateTime begin = DateUtil.beginOfMonth(dateTime);
        System.out.println("月初：" + begin);

        // 是否同一天
        Date date1 = DateUtil.parse("2023-01-01 15:00:00").toJdkDate();
        Date date2 = DateUtil.parse("2023-01-02 00:00:00").toJdkDate();
        boolean sameDay = DateUtil.isSameDay(date1, date2);
        System.out.println(sameDay);
    }

    /**
     * DateUtil.parse
     */
    @Test
    public void parse() {
        String dateStr = "2017-03-01";
        Date date1 = DateUtil.parse(dateStr);
        System.out.println(date1);
        Date date2 = DateUtil.parse(dateStr, "yyyy-MM-dd");
        System.out.println(date2);
    }

    /**
     * DateUtil.format
     */
    @Test
    public void format() {
        String date = DateUtil.format(new Date(), DatePattern.PURE_DATE_PATTERN);
        System.out.println(date);

        String s = DateUtil.formatDate(new Date());
        System.out.println(s);
    }

    /**
     * 获取当前时间
     */
    @Test
    public void currentDate() {
        // 当前时间，转换为{@link DateTime}对象
        DateTime date = DateUtil.date();
        System.out.println(date);

        //当前时间，转换为{@link DateTime}对象，忽略毫秒部分
        DateTime dateSecond = DateUtil.dateSecond();
        System.out.println(dateSecond);

        // 当前时间的时间戳
        long current = DateUtil.current();
        System.out.println(current);

        // 当前时间的时间戳（秒）
        long currentSeconds = DateUtil.currentSeconds();
        System.out.println(currentSeconds);

        // 当前时间，格式 yyyy-MM-dd HH:mm:ss
        String now = DateUtil.now();
        System.out.println(now);

        // 当前日期，格式 yyyy-MM-dd
        String today = DateUtil.today();
        System.out.println(today);
    }

}
