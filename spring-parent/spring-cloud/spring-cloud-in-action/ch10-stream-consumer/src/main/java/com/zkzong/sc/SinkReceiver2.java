package com.zkzong.sc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

//@EnableBinding(value = {Sink.class})
public class SinkReceiver2 {

    private static Logger logger = LoggerFactory.getLogger(HelloApplication.class);


    @StreamListener(Sink.INPUT)
    public void receive(User user) {
        logger.info("Received: " + user);
    }

    /**原生实现需要实现转换**/

//    @ServiceActivator(inputChannel=Sink.INPUT)
//    public void receive(User user) {
//        logger.info("Received: " + user);
//    }
//
//    @Transformer(inputChannel = Sink.INPUT, outputChannel = Sink.INPUT)
//    public User transform(String message) throws Exception {
//        ObjectMapper objectMapper = new ObjectMapper();
//        User user = objectMapper.readValue(message, User.class);
//        return user;
//    }

}
