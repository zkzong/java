package com.example.sb2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller是单例
 */
@RestController
//@Scope("prototype")
public class ScopeController {
    private int num = 0;

    ThreadLocal<Integer> uniqueNum = ThreadLocal.withInitial(() -> num);

    /**
     * scope1
     */
    @RequestMapping("/scope1")
    public void testScope() {
        int unum = uniqueNum.get();
        uniqueNum.set(++unum);
        System.out.println(uniqueNum.get());
        //System.out.println(++num);
    }

    /**
     * scope2
     */
    @RequestMapping("/scope2")
    public void testScope2() {
        int unum = uniqueNum.get();
        uniqueNum.set(++unum);
        System.out.println(uniqueNum.get());
        //System.out.println(++num);
    }
}
