package com.zkzong.sb.configurationproperties;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SampleWebApplication.class)
@ActiveProfiles("prod")
public class SamplePropertyLoadingProdTest {
    @Autowired
    private SampleProperty sampleProperty;


    @Test
    public void testLoadingOfProperties() {
        Integer intProp1 = sampleProperty.getIntProp1();
        System.out.println(intProp1);
    }
}
