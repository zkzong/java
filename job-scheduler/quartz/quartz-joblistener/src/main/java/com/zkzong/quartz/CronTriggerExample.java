package com.zkzong.quartz;

import com.zkzong.quartz.listener.HelloJobListener;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.matchers.GroupMatcher;
import org.quartz.impl.matchers.KeyMatcher;

/**
 * Created by Zong on 2016/9/24.
 */
public class CronTriggerExample {
    public static void main(String[] args) throws SchedulerException {
        JobKey jobKey = new JobKey("dummyJobName", "group1");
        JobDetail job = JobBuilder.newJob(HelloJob.class)
                .withIdentity(jobKey).build();

        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("dummyTriggerName", "group1")
                .withSchedule(
                        CronScheduleBuilder.cronSchedule("0/5 * * * * ?")
                ).build();

        Scheduler scheduler = new StdSchedulerFactory().getScheduler();

        // Listener attached to jobKey
        scheduler.getListenerManager().addJobListener(
                new HelloJobListener(), KeyMatcher.keyEquals(jobKey)
        );

        // Listener attached to group named "group1" only.
        scheduler.getListenerManager().addJobListener(
                new HelloJobListener(), GroupMatcher.jobGroupEquals("group1")
        );

        scheduler.start();
        scheduler.scheduleJob(job, trigger);
    }
}
