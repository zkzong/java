package org.example;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.calendar.AnnualCalendar;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class AnnualCalendarDemo {
    public static void main(String[] args) throws Exception {
        SchedulerFactory sf = new StdSchedulerFactory();
        Scheduler scheduler = sf.getScheduler();
        scheduler.start();

        // 定义日历
        AnnualCalendar holidays = new AnnualCalendar();

        // 排除圣诞节-每年的圣诞节，而不仅是2019年
        Calendar christmas = new GregorianCalendar(2019, 12, 25);
        holidays.setDayExcluded(christmas, true);

        // 调度器添加日历
        scheduler.addCalendar("holidays", holidays, false, false);

        JobDetail jobDetail = JobBuilder.newJob(MyJob.class)
                .withIdentity("job1", "group1")
                .usingJobData("quartz", "Quartz")
                .build();

        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger1", "group1")
                .startNow()
                .modifiedByCalendar("holidays")
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(2)
                        .repeatForever())
                .build();

        Date firstRunTime = scheduler.scheduleJob(jobDetail, trigger);
        System.out.println(jobDetail.getKey() + " 第一次触发： " + firstRunTime);
    }
}
