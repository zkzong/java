package com.zkzong.sb.log4j2.job;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: Zong
 * @Date: 2018/12/9
 */
@Component
@Slf4j
public class LogJob {

    /**
     * 2秒钟执行1次
     */
    @Scheduled(fixedRate = 2 * 1000)
    public void logging() {
        Date now = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(now);
        log.debug("===debug=== {}", format);
        log.info("===info=== {}", format);
        log.error("===error=== {}", format);
    }

}
