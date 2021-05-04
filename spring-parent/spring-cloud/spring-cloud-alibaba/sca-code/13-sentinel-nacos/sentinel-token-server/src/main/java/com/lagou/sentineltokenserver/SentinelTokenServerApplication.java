package com.lagou.sentineltokenserver;

import com.alibaba.csp.sentinel.cluster.server.ClusterTokenServer;
import com.alibaba.csp.sentinel.cluster.server.SentinelDefaultTokenServer;
import com.alibaba.csp.sentinel.cluster.server.config.ClusterServerConfigManager;
import com.alibaba.csp.sentinel.cluster.server.config.ServerTransportConfig;
import com.alibaba.csp.sentinel.slots.block.flow.ClusterFlowConfig;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;
import java.util.List;

@SpringBootApplication
public class SentinelTokenServerApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SentinelTokenServerApplication.class, args);
        ClusterTokenServer tokenServer = new SentinelDefaultTokenServer();
        //传输配置
        ClusterServerConfigManager.loadGlobalTransportConfig(new ServerTransportConfig()
                .setIdleSeconds(600).setPort(9201));
        ClusterServerConfigManager.loadServerNamespaceSet(Collections.singleton("default"));
        tokenServer.start();

    }

    //构建一个和客户端一模一样的配置规则
    private static List<FlowRule> buildFlowRuleLikeClient(){
        FlowRule flowRule = new FlowRule();
        flowRule.setResource("hello");
        flowRule.setGrade(1);
        flowRule.setCount(3.0);
        flowRule.setControlBehavior(0);
        flowRule.setWarmUpPeriodSec(10);
        flowRule.setMaxQueueingTimeMs(500);
        flowRule.setClusterMode(true);
        flowRule.setLimitApp("default");
        //这里的 187 是我在集群限流客户端断点发现的，具体 FlowRuleChecker#passClusterCheck()
        flowRule.setClusterConfig(new ClusterFlowConfig().setFlowId(187L).setThresholdType(1)
                .setFallbackToLocalWhenFail(true).setStrategy(0)
                .setSampleCount(10).setWindowIntervalMs(1000));
        return Collections.singletonList(flowRule);
    }

}
