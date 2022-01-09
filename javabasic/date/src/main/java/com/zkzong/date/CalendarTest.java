package com.zkzong.date;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class CalendarTest {

    @Test
    public void add() {
        Calendar calendar = GregorianCalendar.getInstance(Locale.getDefault());
        System.out.println(calendar.getTime());

        calendar.add(1, 1);
        System.out.println(calendar.getTime());

        System.out.println(Calendar.YEAR);
    }

    @Test
    public void test() {
        SimpleDateFormat df1 = new SimpleDateFormat("YYYY-MM-dd");
        SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");

        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, 2021);
        c.set(Calendar.MONTH, 11);

        // 2021年12月25日周六
        c.set(Calendar.DATE, 25);
        System.out.println("YYYY-MM-dd = " + df1.format(c.getTime()));
        System.out.println("yyyy-MM-dd = " + df2.format(c.getTime()));

        // 分割线
        System.out.println("========================");

        // 2021年12月26日 周日
        c.set(Calendar.DATE, 26);
        System.out.println("YYYY-MM-dd = " + df1.format(c.getTime()));
        System.out.println("yyyy-MM-dd = " + df2.format(c.getTime()));

        // 输出：
        //YYYY-MM-dd = 2021-12-25
        //yyyy-MM-dd = 2021-12-25
        //========================
        //YYYY-MM-dd = 2022-12-26
        //yyyy-MM-dd = 2021-12-26
    }

}
