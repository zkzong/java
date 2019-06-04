package com.zkzong;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class ConnectionManager {

    public static URLConnection openUrlConnection(String url, String postData) throws IOException {
        URL realUrl = new URL(url);
        URLConnection conn = (HttpURLConnection) realUrl.openConnection();
        return conn;
    }

}
