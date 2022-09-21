package org.example.quartz.common;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

/**
 * Created by Zong on 2016/9/24.
 */
public class SimpleTriggerExample {
    public static void main(String[] args) throws SchedulerException {
        // Quartz 1.6.3
        // JobDetail job = new JobDetail();
        // job.setName("dummyJobName");
        // job.setJobClass(HelloJob.class);
        JobDetail job = JobBuilder.newJob(HelloJob.class)
                .withIdentity("dummyJobName", "group1").build();

        //Quartz 1.6.3
        // SimpleTrigger trigger = new SimpleTrigger();
        // trigger.setName("dummyTriggerName");
        // trigger.setStartTime(new Date(System.currentTimeMillis() + 1000));
        // trigger.setRepeatCount(SimpleTrigger.REPEAT_INDEFINITELY);
        // trigger.setRepeatInterval(30000);

        // Trigger the job to run on the next round minute
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("dummyJobName", "group1")
                .withSchedule(
                        SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(5).repeatForever()
                ).build();

        // schedule it
        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
        scheduler.start();
        scheduler.scheduleJob(job, trigger);
    }
}
