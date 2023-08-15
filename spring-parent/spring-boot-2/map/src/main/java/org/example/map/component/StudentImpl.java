package com.example.map.component;

import org.springframework.stereotype.Component;

@Component("student")
public class StudentImpl implements IPerson {

    @Override
    public void doWork() {
        System.out.println("I am studying");
    }

}
