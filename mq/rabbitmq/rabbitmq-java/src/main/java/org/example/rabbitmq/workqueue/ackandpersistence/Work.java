package org.example.rabbitmq.workqueue.ackandpersistence;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by zong on 2017/3/1.
 * 消息持久化
 * 公平转发
 */
public class Work {
    // 队列名称
    private final static String QUEUE_NAME = "workqueue";

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        // 区分不同工作进程的输出
        int hashCode = Work.class.hashCode();
        // 创建连接和频道
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        // 声明队列
        boolean durable = true;
        channel.queueDeclare(QUEUE_NAME, durable, false, false, null);
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        // 设置随大服务转发消息数量
        int prefetchCount = 1;
        channel.basicQos(prefetchCount);
        QueueingConsumer consumer = new QueueingConsumer(channel);
        // 指定消费队列
        boolean ack = false; // 打开应答机制
        channel.basicConsume(QUEUE_NAME, ack, consumer);
        while (true) {
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            String message = new String(delivery.getBody());

            System.out.println(hashCode + " [x] Received '" + message + "'");
            doWork(message);
            System.out.println(hashCode + " [x] Done");
            // 发送应答
            channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
        }
    }

    /**
     * 每个点耗时1s
     *
     * @param message
     */
    private static void doWork(String message) throws InterruptedException {
        for (char ch : message.toCharArray()) {
            if (ch == '.') {
                Thread.sleep(1000);
            }
        }
    }
}
