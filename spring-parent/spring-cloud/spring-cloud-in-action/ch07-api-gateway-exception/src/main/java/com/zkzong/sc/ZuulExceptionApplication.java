package com.zkzong.sc;

import com.netflix.zuul.FilterProcessor;
import com.zkzong.sc.filter.DidiFilterProcessor;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringCloudApplication
public class ZuulExceptionApplication {

    public static void main(String[] args) {
        FilterProcessor.setProcessor(new DidiFilterProcessor());
        new SpringApplicationBuilder(ZuulExceptionApplication.class).web(true).run(args);
    }
}
