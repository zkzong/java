package org.example.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * Created by Zong on 2016/9/24.
 */
public class HelloJob implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("Hello Quartz! 123");

        // Throw exception for testing
        throw new JobExecutionException("Testing Exception");
    }
}
