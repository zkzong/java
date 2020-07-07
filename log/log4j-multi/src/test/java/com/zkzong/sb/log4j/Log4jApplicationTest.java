package com.zkzong.sb.log4j;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Zong on 2017/5/26.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class Log4jApplicationTest {
    private Logger logger = Logger.getLogger(getClass());

    @Test
    public void test() {
        logger.info("输出info");
        logger.debug("输出debug");
        logger.error("输出error");
    }
}