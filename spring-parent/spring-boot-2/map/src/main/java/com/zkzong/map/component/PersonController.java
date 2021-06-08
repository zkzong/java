package com.zkzong.map.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
    @Autowired
    private PersonService personService;

    @RequestMapping("/get")
    public String get() {
        personService.echo();
        return "success";
    }
}
