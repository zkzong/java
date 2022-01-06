package com.zkzong.listener;

import org.springframework.context.ApplicationEvent;

/**
 * @Author: zong
 * @Date: 2022/1/6
 */
public class MyEvent extends ApplicationEvent {
    public MyEvent(Object source) {
        super(source);
    }
}
