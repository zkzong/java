package com.zkzong.date;

import org.junit.Test;

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

}
