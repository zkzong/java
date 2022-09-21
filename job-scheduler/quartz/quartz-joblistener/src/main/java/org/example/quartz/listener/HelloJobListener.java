package org.example.quartz.listener;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;

/**
 * Created by Zong on 2016/9/24.
 */
public class HelloJobListener implements JobListener {

    public static final String LISTENER_NAME = "dummyJobListenerName";

    @Override
    public String getName() {
        return LISTENER_NAME; // must return a name
    }

    // Run this if job is about to be executed.
    @Override
    public void jobToBeExecuted(JobExecutionContext jobExecutionContext) {
        String jobName = jobExecutionContext.getJobDetail().getKey().toString();
        System.out.println("jobToBeExecuted");
        System.out.println("Job : " + jobName + " is going to start...");
    }

    // No idea when will run this?
    @Override
    public void jobExecutionVetoed(JobExecutionContext jobExecutionContext) {
        System.out.println("jobExecutionVetoed");
    }

    // Run this after job has been executed
    @Override
    public void jobWasExecuted(JobExecutionContext jobExecutionContext, JobExecutionException e) {
        System.out.println("jobWasExecuted");

        String jobName = jobExecutionContext.getJobDetail().getKey().toString();
        System.out.println("Job : " + jobName + " is going to finished...");

        if (!"".equals(e.getMessage())) {
            System.out.println("Exception thrown by: " + jobName + " Exception:" + e.getMessage());
        }
    }
}
