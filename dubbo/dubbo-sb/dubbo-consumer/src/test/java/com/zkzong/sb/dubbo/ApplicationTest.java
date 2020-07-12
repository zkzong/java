package com.zkzong.sb.dubbo;

import com.zkzong.sb.dubbo.service.ComputeService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Zong on 2017/5/12.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ApplicationTest {
    @Autowired
    private ComputeService computeService;

    @Test
    public void testAdd() throws Exception {
        Assert.assertEquals("compute-service:add", new Integer(3), computeService.add(1, 2));
    }
}