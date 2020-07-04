package com.zkzong.sb.configurationproperties;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.Matchers.hasItems;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SampleWebApplication.class)
public class SamplePropertyLoadingTest {
    @Autowired
    private SampleProperty sampleProperty;

    @Value("${prefix.stringProp1}")
    private String stringProp1;

    @Test
    public void testLoadingOfProperties() {
        System.out.println("stringProp1 = " + stringProp1);
        assertThat(sampleProperty.getStringProp1(), equalTo("propValue1"));
        assertThat(sampleProperty.getStringProp2(), equalTo("propValue2"));
        assertThat(sampleProperty.getIntProp1(), equalTo(10));
        assertThat(sampleProperty.getListProp(), hasItems("listValue1", "listValue2"));
        assertThat(sampleProperty.getMapProp(), allOf(hasEntry("key1", "mapValue1"),
                hasEntry("key2", "mapValue2")));
    }
}
