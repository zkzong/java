package com.example.kafka.controller;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    private final Logger logger = LoggerFactory.getLogger(Consumer.class);

    @KafkaListener(topics = "users", groupId = "group_id_1")
    public void consume1(String message) {
        logger.info(String.format("$$ -> Consumed Message -> %s", message));
    }

    @KafkaListener(topics = "users", groupId = "group_id_2")
    public void consume2(ConsumerRecord record) {
        logger.info(String.format("$$ -> Consumed Message -> %s", record));
    }

}
