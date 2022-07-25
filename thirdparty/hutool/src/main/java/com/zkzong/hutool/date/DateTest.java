package com.zkzong.hutool.date;

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
public class DateTest {

    @Test
    public void date() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        // between
        final long between = DateUtil.between(sdf.parse("2021-09-25 20:00:00"), new Date(), DateUnit.DAY);
        System.out.println(between);

        // compare
        final long compare = DateUtil.compare(sdf.parse("2021-09-25 20:00:00"), new Date());
        System.out.println(compare);

        // yesterday
        final Date date = DateUtil.yesterday().toJdkDate();
        System.out.println(date);

        // 月初/月末
        DateTime beginOfMonth = DateUtil.beginOfMonth(new Date());
        System.out.println(beginOfMonth);
        DateTime endOfMonth = DateUtil.endOfMonth(new Date());
        System.out.println(endOfMonth);

        // 下个月月初
        DateTime dateTime = DateUtil.nextMonth();
        System.out.println(dateTime);
        DateTime begin = DateUtil.beginOfMonth(dateTime);
        System.out.println(begin);
    }

}
