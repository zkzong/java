package com.zkzong;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;

/**
 * Hello world!
 */
public class App1 {
    public static void main(String[] args) throws SchedulerException {
        Scheduler scheduler = new StdSchedulerFactory().getScheduler();

        // loop all group
        for (String groupName : scheduler.getJobGroupNames()) {
            // loop all jobs by groupname
//            for (String jobName : scheduler.getJobNames(groupName)) {
//                // get job's trigger
//                Trigger[] triggers = scheduler.getTriggersOfJob(jobName, groupName);
//                Date nextFireTime = triggers[0].getNextFireTime();
//
//                System.out.println("[jobName] : " + jobName + " [groupName] : " + groupName + " - " + nextFireTime);
//            }
        }
    }
}
