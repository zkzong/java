package com.zkzong.common;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * Created by Zong on 2016/9/25.
 */
public class RunMeJob extends QuartzJobBean {
    private RunMeTask runMeTask;

    public void setRunMeTask(RunMeTask runMeTask) {
        this.runMeTask = runMeTask;
    }

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        runMeTask.printMe();
    }
}
