package com.example.disruptor;

import com.lmax.disruptor.EventFactory;
import com.example.disruptor.model.MessageModel;

public class HelloEventFactory implements EventFactory<MessageModel> {
    @Override
    public MessageModel newInstance() {
        return new MessageModel();
    }
}

