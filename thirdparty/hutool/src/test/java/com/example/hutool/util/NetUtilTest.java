package com.example.hutool.util;

import cn.hutool.core.net.NetUtil;
import org.junit.Test;

import java.net.InetAddress;

public class NetUtilTest {

    @Test
    public void net() {
        InetAddress localhost = NetUtil.getLocalhost();
        String hostAddress = localhost.getHostAddress();
        System.out.println(hostAddress);

        String localhostStr = NetUtil.getLocalhostStr();
        System.out.println(localhostStr);

        long l = NetUtil.ipv4ToLong(hostAddress);
        System.out.println(l);
    }
}
