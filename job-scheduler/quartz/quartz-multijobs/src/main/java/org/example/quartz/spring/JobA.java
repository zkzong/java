package org.example.quartz.spring;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * Created by Zong on 2016/9/26.
 */
public class JobA extends QuartzJobBean {
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) {
        System.out.println("Job A is running");
    }
}
