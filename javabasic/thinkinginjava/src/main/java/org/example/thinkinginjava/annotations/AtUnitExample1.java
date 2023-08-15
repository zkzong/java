package com.example.thinkinginjava.annotations;

import com.example.thinkinginjava.atunit.Test;
import com.example.thinkinginjava.util.OSExecute;

/**
 * Created by Zong on 2016/9/19.
 */
public class AtUnitExample1 {
    public String methodOne() {
        return "This is methodOne";
    }

    public int methodTwo() {
        System.out.println("This is methodTwo");
        return 2;
    }

    @Test
    boolean methodOneTest() {
        return methodOne().equals("This is methodOne");
    }

    @Test
    boolean m2() {
        return methodTwo() == 2;
    }

    @Test
    private boolean m3() {
        return true;
    }

    @Test
    private boolean failureTest() {
        return false;
    }

    @Test
    boolean anotherDisappointment() {
        return false;
    }

    public static void main(String[] args) {
        OSExecute.command("java com.example.thinkinginjava.atunit.AtUnit AtUnitExample1");
    }
}
