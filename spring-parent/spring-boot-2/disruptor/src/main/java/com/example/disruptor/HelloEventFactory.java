package com.example.disruptor;

import com.example.disruptor.model.MessageModel;
import com.lmax.disruptor.EventFactory;

public class HelloEventFactory implements EventFactory<MessageModel> {
    @Override
    public MessageModel newInstance() {
        return new MessageModel();
    }
}

