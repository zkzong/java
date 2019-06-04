package com.zkzong.jvm;

import sun.misc.Launcher;

import java.net.URL;

/**
 * Created by Zong on 2016/11/28.
 */
public class ClassLoaderTest {
    public static void main(String[] args) {
        URL[] urls = Launcher.getBootstrapClassPath().getURLs();
        for (int i = 0; i < urls.length; i++) {
            URL url = urls[i];
            System.out.println(url.toExternalForm());
        }

        System.out.println(System.getProperty("sun.boot.class.path"));
    }
}
