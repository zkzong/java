package org.example.apollo.controller;

import com.ctrip.framework.apollo.model.ConfigChange;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.scope.refresh.RefreshScope;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RefreshConfig {

    @Autowired
    private RefreshScope refreshScope;

    @ApolloConfigChangeListener
    public void onChange(ConfigChangeEvent changeEvent) {
        changeEvent.changedKeys().stream().forEach(changeKey -> {
            ConfigChange configChange = changeEvent.getChange(changeKey);
            log.info("Apollo config change, propertyName:[{}], oldValue:{}, newValue:{}", configChange.getPropertyName(), configChange.getOldValue(), configChange.getNewValue());
        });
        refreshScope.refreshAll();
    }
}
