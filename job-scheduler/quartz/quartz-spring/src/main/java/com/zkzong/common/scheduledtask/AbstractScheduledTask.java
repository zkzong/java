package com.zkzong.common.scheduledtask;

/**
 * Created by Zong on 2016/10/21.
 */
public abstract class AbstractScheduledTask {

    /**
     * 每个租户均执行一次，配置租户的定时任务时，方法应该指向此方法
     */
    public void execute() {
//        for (String tenant : DataSourceContainer.getTenants()) {
//            FacesContext.setCurrentTenant(tenant);
//            task();
//        }
        task();
    }

    /**
     * 定时执行的任务
     */
    protected abstract void task();
}
