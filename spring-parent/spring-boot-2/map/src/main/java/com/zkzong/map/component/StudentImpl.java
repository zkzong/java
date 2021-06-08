package com.zkzong.map.component;

import com.zkzong.map.component.IPerson;
import org.springframework.stereotype.Component;

@Component("student")
public class StudentImpl implements IPerson {

    @Override
    public void doWork() {
        System.out.println("I am studying");
    }

}
