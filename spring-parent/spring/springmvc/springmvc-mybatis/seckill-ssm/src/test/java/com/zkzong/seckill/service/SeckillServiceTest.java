package com.zkzong.seckill.service;

import com.zkzong.seckill.dto.Exposer;
import com.zkzong.seckill.dto.SeckillExecution;
import com.zkzong.seckill.entity.Seckill;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by zong on 17-5-7.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"
})
public class SeckillServiceTest {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SeckillService seckillService;

    @Test
    public void getSerkillList() throws Exception {
        List<Seckill> serkillList = seckillService.getSeckillList();
        System.out.println(serkillList);
    }

    @Test
    public void getById() throws Exception {
        long id = 1000;
        Seckill seckill = seckillService.getById(id);
        System.out.println(seckill);
    }

    @Test
    public void exportSeckillUrl() throws Exception {
        long id = 1000;
        Exposer exposer = seckillService.exportSeckillUrl(id);
        System.out.println(exposer);
    }

    @Test
    public void executeSeckill() throws Exception {
        long id = 1000;
        long phone = 13502171122L;
        String md5 = "e83eef2cc6b033ca0848878afc20e80d";
        SeckillExecution seckillExecution = seckillService.executeSeckill(id, phone, md5);
        System.out.println(seckillExecution);
    }

}