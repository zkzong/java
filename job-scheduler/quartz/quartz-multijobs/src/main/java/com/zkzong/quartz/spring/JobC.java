package com.zkzong.quartz.spring;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * Created by Zong on 2016/9/26.
 */
public class JobC extends QuartzJobBean {
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) {
        System.out.println("Job C is running");
    }
}
