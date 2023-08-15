package com.example.jodatime;

import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;
import org.joda.time.DateTimeZone;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class JodaTimeTest {

    @Test
    public void dateTime() {
        DateTime dt = new DateTime();
        Date jdkDate = dt.toDate();
        System.out.println(jdkDate);
        dt = new DateTime(jdkDate);
        System.out.println(dt);

        Calendar jdkCal = dt.toCalendar(Locale.CHINESE);
        System.out.println(jdkCal);
        dt = new DateTime(jdkCal);

        GregorianCalendar jdkGCal = dt.toGregorianCalendar();
        System.out.println(jdkGCal);
        dt = new DateTime(jdkGCal);

        int iDow = dt.getDayOfWeek();
        System.out.println(iDow);
        System.out.println(DateTimeConstants.MONDAY);

        DateTime.Property week = dt.dayOfWeek();
        System.out.println(week.get());

        System.out.println(week.getAsShortText());
        System.out.println(week.getAsText());

        System.out.println(week.getAsText(Locale.ENGLISH));

        System.out.println(dt.getEra());
        System.out.println(dt.getYear());
        System.out.println(dt.getWeekyear());

        System.out.println(dt.monthOfYear().getAsText());
        System.out.println(dt.dayOfMonth().getMaximumValue());
        System.out.println(dt.yearOfEra().isLeap());

        System.out.println(dt.getHourOfDay());
        System.out.println(dt.getMinuteOfHour());
        System.out.println(dt.getSecondOfMinute());

        DateTime dateTime = dt.withZone(DateTimeZone.forID("Europe/London"));
        System.out.println(dateTime);
    }

    @Test
    public void format() {
        DateTime dateTime = new DateTime();
        System.out.println(dateTime.toString("yyyy-MM-dd"));
        System.out.println(dateTime.toString("yyyy-MM-dd hh:mm:ss"));
    }

}