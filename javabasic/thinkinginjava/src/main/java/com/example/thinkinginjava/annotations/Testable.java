package com.example.thinkinginjava.annotations;

import com.example.thinkinginjava.atunit.Test;

/**
 * Created by Zong on 2016/9/14.
 */
public class Testable {

    public void execute() {
        System.out.println("Executing...");
    }

    @Test
    public void testExecute() {
        execute();
    }
}
