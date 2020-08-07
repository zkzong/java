package com.zkzong.http.util.cm;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

/**
 * @Author: zong
 * @Date: 2019.1.18
 */
public class HttpClientUtil {
    public static CloseableHttpClient getHttpClient() {
        // 连接池对象
        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
        // 将最大连接数增加到200
        connectionManager.setMaxTotal(200);
        // 将每个路由的默认最大连接数增加到20
        connectionManager.setDefaultMaxPerRoute(20);
        // HttpClient对象
        CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(connectionManager).build();

        return httpClient;
    }
}
