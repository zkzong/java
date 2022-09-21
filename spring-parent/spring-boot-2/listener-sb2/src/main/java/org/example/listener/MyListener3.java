package org.example.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;

/**
 * @Author: zong
 * @Date: 2022/1/6
 */
@Slf4j
public class MyListener3 implements ApplicationListener<MyEvent> {

    @Override
    public void onApplicationEvent(MyEvent event) {
        log.info(String.format("%s监听到事件源：%s", MyListener3.class.getName(), event.getSource()));
    }
}

