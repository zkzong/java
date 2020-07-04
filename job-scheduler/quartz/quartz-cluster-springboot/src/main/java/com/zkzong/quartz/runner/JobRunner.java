package com.zkzong.quartz.runner;

import com.zkzong.quartz.factory.MyJobFactory;
import com.zkzong.quartz.job.CronJob;
import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class JobRunner implements CommandLineRunner {

    @Autowired
    private MyJobFactory myJobFactory;
    @Autowired
    private Scheduler scheduler;

    @Override
    public void run(String... args) throws Exception {
        try {
            scheduler.setJobFactory(myJobFactory);
            JobDataMap jobDataMap = new JobDataMap();
            jobDataMap.put("taskData", "taskData");
            JobDetail tesJobDetail = JobBuilder.newJob(CronJob.class)
                    .withIdentity("tesJob", "tesJob")
                    .withDescription("定时任务demo")
                    .usingJobData(jobDataMap)
                    .build();
            CronScheduleBuilder tesJobCronScheduleBuilder = CronScheduleBuilder.cronSchedule("0/10 * * * * ?");
            CronTrigger tesJobCronTrigger = TriggerBuilder.newTrigger()
                    .withIdentity("tesJobTrigger", "tesJob")
                    .withSchedule(tesJobCronScheduleBuilder)
                    .build();
            scheduler.scheduleJob(tesJobDetail, tesJobCronTrigger);
            scheduler.start();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}
