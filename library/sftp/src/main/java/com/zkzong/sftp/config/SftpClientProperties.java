package com.zkzong.sftp.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(ignoreUnknownFields = false, prefix = "sftp.client")
@Deprecated
public class SftpClientProperties {

    // 服务器连接ip
    private String host;
    // 用户名
    private String username;
    // 密码
    private String password;
    // 端口号
    private int port = 22;

}
