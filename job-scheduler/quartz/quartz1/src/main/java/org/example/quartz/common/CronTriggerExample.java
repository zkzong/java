package org.example.quartz.common;

import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;

import java.text.ParseException;

/**
 * Created by Zong on 2016/9/24.
 */
public class CronTriggerExample {
    public static void main(String[] args) throws SchedulerException, ParseException {
        JobDetail job = new JobDetail();
        job.setName("dummyJobName");
        job.setJobClass(HelloJob.class);

        // configure the scheduler time
        CronTrigger trigger = new CronTrigger();
        trigger.setName("dummyTriggerName");
        trigger.setCronExpression("0/3 * * * * ?");

        // schedule it
        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
        scheduler.start();
        scheduler.scheduleJob(job, trigger);
    }
}
