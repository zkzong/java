package org.example.both;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = RandomApplication.class)
@PropertySource(value = {"config/random.properties"})
public class RandomConfigTest {

    @Autowired
    private RandomConfig randomConfig;

    @Test
    public void test() {
        System.out.println(randomConfig.getSecret());
        System.out.println(randomConfig.getIntNumber());
        System.out.println(randomConfig.getLongNumber());
        System.out.println(randomConfig.getUuid());
        System.out.println(randomConfig.getLessTen());
        System.out.println(randomConfig.getRange());
    }
}