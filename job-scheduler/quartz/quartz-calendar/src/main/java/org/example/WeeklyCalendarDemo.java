package org.example;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.calendar.WeeklyCalendar;

import java.util.Calendar;
import java.util.Date;

public class WeeklyCalendarDemo {
    public static void main(String[] args) throws SchedulerException {
        SchedulerFactory sf = new StdSchedulerFactory();
        Scheduler scheduler = sf.getScheduler();
        scheduler.start();

        WeeklyCalendar weekly = new WeeklyCalendar();
        // 周六日不执行
        weekly.setDayExcluded(Calendar.SATURDAY, true);
        weekly.setDayExcluded(Calendar.SUNDAY, true);

        // 调度器添加日历
        scheduler.addCalendar("weekly", weekly, false, false);

        JobDetail jobDetail = JobBuilder.newJob(MyJob.class).build();

        Trigger trigger = TriggerBuilder.newTrigger()
                .startNow()
                .modifiedByCalendar("weekly")
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(2)
                        .repeatForever())
                .build();

        Date firstRunTime = scheduler.scheduleJob(jobDetail, trigger);
        System.out.println(jobDetail.getKey() + " 第一次触发： " + firstRunTime);
    }
}
