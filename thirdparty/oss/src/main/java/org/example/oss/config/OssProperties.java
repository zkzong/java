package org.example.oss.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: zongz
 * @Date: 2024/10/9
 */
@ConfigurationProperties(prefix = "aliyun.oss")
@Configuration
@Data
public class OssProperties {

    private String endPoint;
    private String accessKeyId;
    private String accessKeySecret;
    private String bucketName;

}
