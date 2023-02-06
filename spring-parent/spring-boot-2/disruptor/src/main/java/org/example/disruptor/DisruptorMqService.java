package org.example.disruptor;

public interface DisruptorMqService {

    /**
     * 消息
     *
     * @param message
     */
    void sayHelloMq(String message);
}
