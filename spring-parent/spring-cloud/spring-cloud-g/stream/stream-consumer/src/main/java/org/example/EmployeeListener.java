package com.example;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@EnableBinding(EmployeeBinding.class)
public class EmployeeListener {
    @StreamListener(target = EmployeeBinding.EMP_CHANNEL)
    public void processEmpNameChannel(String msg) {
        System.out.println(msg);
    }
}
