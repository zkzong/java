package com.example.date;

import org.junit.Test;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateTest {
    @Test
    public void date() {
        Date date = new Date(0);
        System.out.println(date);
    }

    @Test
    public void time() {
        Date date = new Date();
        System.out.println(date.getTime());
    }

    @Test
    public void str2Date() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = dateFormat.parse("2018-10-10");
        System.out.println(date);
    }

    @Test
    public void compare() throws ParseException {
        String strDateFormat = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);

        Date d1 = sdf.parse("2020-10-10 00:00:00");
        Date d2 = sdf.parse("2020-10-11 00:00:00");
        System.out.println(d1.compareTo(d2));
    }

    /***
     * 两个时间相隔几小时，保留两位小数
     *
     */
    @Test
    public void waitTime() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        Date startTime = Date.from(LocalDateTime.parse("2024-10-10 10:00:00", dateTimeFormatter).atZone(ZoneId.systemDefault()).toInstant());
        Date endTime = Date.from(LocalDateTime.parse("2024-10-11 10:30:00", dateTimeFormatter).atZone(ZoneId.systemDefault()).toInstant());
        long times = endTime.getTime() - startTime.getTime();
        double hours = (double) times / (60 * 60 * 1000);
        BigDecimal hourbd = BigDecimal.valueOf(hours);
        BigDecimal waitTime = hourbd.setScale(2, BigDecimal.ROUND_HALF_UP);
        System.out.println(waitTime);
    }
}
