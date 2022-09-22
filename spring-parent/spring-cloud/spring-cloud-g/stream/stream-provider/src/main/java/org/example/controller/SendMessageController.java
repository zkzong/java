package org.example.controller;

import org.example.provider.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendMessageController {

    @Autowired
    private IMessageProvider iMessageProvider;

    @GetMapping(value = "/sendMessage")
    public String send() {
        return iMessageProvider.sendMessage();
    }
}


