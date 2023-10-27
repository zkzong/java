package com.example.hutool.util;

import cn.hutool.core.util.URLUtil;
import org.junit.Test;

import java.net.URI;
import java.net.URL;

public class URLUtilTest {

    @Test
    public void url() {
        String s = "baidu.com/aa";
        String normalize = URLUtil.normalize(s);
        System.out.println(normalize);
        URL url = URLUtil.url(normalize);
        URI host = URLUtil.getHost(url);
        System.out.println(host);
    }

}
