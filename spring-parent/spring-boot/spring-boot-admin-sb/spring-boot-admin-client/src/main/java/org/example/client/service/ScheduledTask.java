package org.example.client.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ScheduledTask {

    private static final Logger logger = LoggerFactory.getLogger(ScheduledTask.class);

    private Integer count0 = 1;
    private Integer count1 = 1;
    private Integer count2 = 1;

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() throws InterruptedException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        logger.info(String.format("---第%s次执行，当前时间为：%s", count0++, dateFormat.format(new Date())));
    }

    @Scheduled(fixedDelay = 5000)
    public void reportCurrentTimeAfterSleep() throws InterruptedException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        logger.info(String.format("===第%s次执行，当前时间为：%s", count1++, dateFormat.format(new Date())));
    }

    @Scheduled(cron = "*/5 * * * * *")
    public void reportCurrentTimeCron() throws InterruptedException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        logger.info(String.format("+++第%s次执行，当前时间为：%s", count2++, dateFormat.format(new Date())));
    }
}
