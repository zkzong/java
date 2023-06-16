package org.example.sb.configurationproperties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author zkzong
 * @date 2017/12/15
 */
@Component
public class StartupRunner implements CommandLineRunner {

    @Autowired
    private SampleProperty sampleProperty;

    @Override
    public void run(String... strings) throws Exception {
        System.out.println(sampleProperty.getStringProp1());
        System.out.println(sampleProperty.getStringProp2());
        System.out.println(sampleProperty.getIntProp1());
        System.out.println(sampleProperty.getListProp());
        System.out.println(sampleProperty.getMapProp());
    }
}
