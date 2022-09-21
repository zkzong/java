package org.example.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @Author: zong
 * @Date: 2022/1/6
 */
@Component
@Slf4j
public class MyListener2 implements ApplicationListener<MyEvent> {

    @Override
    public void onApplicationEvent(MyEvent event) {
        log.info(String.format("%s监听到事件源：%s", MyListener2.class.getName(), event.getSource()));
    }
}
