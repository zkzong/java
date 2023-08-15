package com.example.controller;

import com.example.EmployeeBinding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeProducerController {
    private MessageChannel messageChannel;

    public EmployeeProducerController(EmployeeBinding empBinding) {
        messageChannel = empBinding.publishMessage();
    }

    @GetMapping("/publish/{msg}")
    public void publish(@PathVariable String msg) {
        this.messageChannel.send(MessageBuilder.withPayload(msg)
                .build());
    }
}


