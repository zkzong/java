package com.example.junit5;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @Author: zong
 * @Date: 2021/12/13
 */
class CalculateTest {

    @org.junit.jupiter.api.Test
    void add() {
    }

    @org.junit.jupiter.api.Test
    void subtract() {
    }

    @org.junit.jupiter.api.Test
    void multiply() {
    }

    @org.junit.jupiter.api.Test
    void divide() {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            Integer.parseInt("1a");
        });

        String expectedMessage = "For input string";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));


        Exception exp = assertThrows(ArithmeticException.class, () -> {
            new Calculate().divide(6, 0);
        });

        String expMessage = "/ by zero";
        String actMessage = exp.getMessage();
        assertTrue(actMessage.contains(expMessage));
    }
}