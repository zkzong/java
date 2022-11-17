package org.example.apollo.controller;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * @Author: zong
 * @Date: 2021/10/26
 */
@ConfigurationProperties(prefix = "config")
@Component
@RefreshScope
@Data
public class PropConfig {

    private String info;

}
