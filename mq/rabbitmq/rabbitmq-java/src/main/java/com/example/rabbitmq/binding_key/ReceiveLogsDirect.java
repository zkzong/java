package com.example.rabbitmq.binding_key;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeoutException;

/**
 * Created by zong on 2017/3/2.
 */
public class ReceiveLogsDirect {
    private final static String EXCHANGE_NAME = "ex_logs_direct";
    private final static String[] SEVERITIES = {"info", "warning", "error"};

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        // 创建连接和频道
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        // 声明direct类型转发器
        channel.exchangeDeclare(EXCHANGE_NAME, "direct");

        // 创建一个非持久的，唯一的且自动删除的队列
        String queueName = channel.queueDeclare().getQueue();
        String severity = getSeverity();
        // 指定binding_key
        channel.queueBind(queueName, EXCHANGE_NAME, severity);

        System.out.println(" [*] Waiting for " + severity + " logs. To exit press CTRL+C");

        QueueingConsumer consumer = new QueueingConsumer(channel);
        // 指定接收者，第二个参数为自动应答，无需手动应答
        channel.basicConsume(queueName, true, consumer);

        while (true) {
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            String message = new String(delivery.getBody());

            System.out.println(" [x] Received '" + message + "'");
        }
    }

    /**
     * 随机产生一种日志类型
     *
     * @return
     */
    private static String getSeverity() {
        Random random = new Random();
        int ranVal = random.nextInt(3);
        return SEVERITIES[ranVal];
    }
}
