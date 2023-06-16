package org.example.tx.controller;

import org.example.tx.service.TxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zkzong
 * @Date: 2018.11.14
 */
@RestController
public class TxController {

    @Autowired
    private TxService txService;

    @RequestMapping(value = "insert")
    public String insert() {
        txService.insertAll("ggg", 30);
        return "添加成功";
    }
}
