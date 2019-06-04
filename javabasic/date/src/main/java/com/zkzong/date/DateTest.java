package com.zkzong.date;

import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
}
