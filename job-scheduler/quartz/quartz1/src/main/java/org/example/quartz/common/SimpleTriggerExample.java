package org.example.quartz.common;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleTrigger;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

/**
 * Created by Zong on 2016/9/24.
 */
public class SimpleTriggerExample {
    public static void main(String[] args) throws SchedulerException {
        JobDetail job = new JobDetail();
        job.setName("dummyJobName");
        job.setJobClass(HelloJob.class);

        // configure the scheduler time
        SimpleTrigger trigger = new SimpleTrigger();
        trigger.setName("dummyTriggerName");
        trigger.setStartTime(new Date(System.currentTimeMillis() + 1000));
        trigger.setRepeatCount(SimpleTrigger.REPEAT_INDEFINITELY);
        trigger.setRepeatInterval(3000);

        // schedule it
        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
        scheduler.start();
        scheduler.scheduleJob(job, trigger);
    }
}
