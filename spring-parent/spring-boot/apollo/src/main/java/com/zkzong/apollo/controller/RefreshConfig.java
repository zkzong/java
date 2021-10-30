package com.zkzong.apollo.controller;

import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;
import org.springframework.cloud.context.scope.refresh.RefreshScope;
import org.springframework.stereotype.Component;

@Component
public class RefreshConfig {

    private PropConfig propConfig;
    private RefreshScope refreshScope;

    public RefreshConfig(PropConfig propConfig, RefreshScope refreshScope) {
        this.propConfig = propConfig;
        this.refreshScope = refreshScope;
    }

    @ApolloConfigChangeListener(interestedKeyPrefixes = {"config."})
    public void onChange(ConfigChangeEvent changeEvent) {
        System.out.println("before refresh " + propConfig.toString());
        refreshScope.refresh("sampleRedisConfig");
        System.out.println("after refresh " + propConfig.toString());
    }
}
