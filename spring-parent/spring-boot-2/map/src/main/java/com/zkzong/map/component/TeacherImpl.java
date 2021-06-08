package com.zkzong.map.component;

import com.zkzong.map.component.IPerson;
import org.springframework.stereotype.Component;

@Component("teacher")
public class TeacherImpl implements IPerson {

    @Override
    public void doWork() {
        System.out.println("I am teaching");
    }

}
