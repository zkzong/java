package com.example.guava;

import com.google.common.escape.Escaper;
import com.google.common.net.UrlEscapers;

/**
 * Created by zong on 2017/3/4.
 */
public class UrlTest {
    public static void main(String[] args) {
        String url = "http://example.com/path1/path2?keyword=someKeyword#someFragment";
        Escaper escaper = UrlEscapers.urlFormParameterEscaper();
        System.out.println(escaper.escape(url));

        System.out.println(UrlEscapers.urlPathSegmentEscaper().escape(url));

        System.out.println(UrlEscapers.urlFragmentEscaper().escape(url));

    }
}
