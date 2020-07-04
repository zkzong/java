package com.zkzong.script;

import com.dangdang.ddframe.job.config.JobCoreConfiguration;
import com.dangdang.ddframe.job.config.script.ScriptJobConfiguration;
import com.dangdang.ddframe.job.lite.api.JobScheduler;
import com.dangdang.ddframe.job.lite.api.strategy.impl.AverageAllocationJobShardingStrategy;
import com.dangdang.ddframe.job.lite.config.LiteJobConfiguration;
import com.dangdang.ddframe.job.reg.base.CoordinatorRegistryCenter;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperConfiguration;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;

/**
 * @Author: zkzong
 * @Date: 2019/11/8
 */
public class ScriptJobTest {
    // 如果修改了代码，跑之前清空ZK
    public static void main(String[] args) {
        // ZK注册中心
        CoordinatorRegistryCenter regCenter = new ZookeeperRegistryCenter(new ZookeeperConfiguration("localhost:2181", "gupao-ejob-standalone"));
        regCenter.init();

        // 定义作业核心配置
        JobCoreConfiguration scriptJobCoreConfig = JobCoreConfiguration.newBuilder("MyScriptJob", "0/4 * * * * ?", 2).build();
        // 定义SCRIPT类型配置
        ScriptJobConfiguration scriptJobConfig = new ScriptJobConfiguration(scriptJobCoreConfig, "1.bat");

        // 作业分片策略
        // 基于平均分配算法的分片策略
        String jobShardingStrategyClass = AverageAllocationJobShardingStrategy.class.getCanonicalName();

        // 定义Lite作业根配置
        // LiteJobConfiguration scriptJobRootConfig = LiteJobConfiguration.newBuilder(scriptJobConfig).jobShardingStrategyClass(jobShardingStrategyClass).build();
        LiteJobConfiguration scriptJobRootConfig = LiteJobConfiguration.newBuilder(scriptJobConfig).build();

        // 构建Job
        new JobScheduler(regCenter, scriptJobRootConfig).init();
        // new JobScheduler(regCenter, scriptJobRootConfig, jobEventConfig).init();
    }
}
