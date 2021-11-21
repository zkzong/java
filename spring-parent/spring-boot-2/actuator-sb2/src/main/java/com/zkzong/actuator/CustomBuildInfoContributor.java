package com.zkzong.actuator;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Date;

/**
 * @Author: zong
 * @Date: 2021/11/20
 */
@Component
public class CustomBuildInfoContributor implements InfoContributor {

    @Override
    public void contribute(Info.Builder builder) {
        builder.withDetail("build",
                Collections.singletonMap("timestamp", new Date()));
    }

}
