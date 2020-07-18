# mq

## ActiveMQ

http://127.0.0.1:8161/admin/

用户名和密码：admin

[http://blog.csdn.net/jiuqiyuliang/article/details/46701559](http://blog.csdn.net/jiuqiyuliang/article/details/46701559)

## ActiveMQ + Spring

http://www.cnblogs.com/wyjmahone/p/6296886.html

spring版本不能用4.3.6.RELEASE

## RabbitMQ

[http://blog.csdn.net/lmj623565791/article/category/2386657](http://blog.csdn.net/lmj623565791/article/category/2386657)
[http://labreeze.iteye.com/blog/2275740](http://labreeze.iteye.com/blog/2275740)

开启网页控制台

rabbitmq-plugins.bat list
rabbitmq-plugins.bat enable rabbitmq_management
http://localhost:15672
用户名和密码：guest

消息应答：解决了某个接收者异常导致信息丢失的问题。
消息应答默认是打开的。
```java
boolean ack = false; // 打开应答机制
channel.basicConsume(QUEUE_NAME, ack, consumer);
// 另外需要在每次处理完成一个消息后，手动发送一次应答。
channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
```

消息持久化：解决RabbitMQ服务被停止消息丢失问题。
需要做两件事：
1. 给队列设置持久化标志
```java
boolean durable = true;
channel.queueDeclare("task_queue", durable, false, false, null);
```
2. 给消息设置持久化标志。通过设置MessageProperties（implements BasicProperties）值为PERSISTENT_TEXT_PLAIN。
```java
channel.basicPublish("", "task_queue", MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes());
```

公平转发：

使用basicQos方法，传递参数为prefetchCount = 1。这样告诉RabbitMQ不要在同一时间给一个消费者超过一条消息。换句话说，只有在消费者空闲的时候会发送下一条信息。

这种模式下支持动态增加消费者，因为消息并没有发送出去，动态增加了消费者马上投入工作。而默认的转发机制会造成，即使动态增加了消费者，此时的消息已经分配完毕，无法立即加入工作，即使有很多未完成的任务。

发布/订阅

转发器
匿名转发器
临时队列
绑定

路由选择

主题

发往主题类型的转发器的消息不能随意的设置选择键（routing_key），必须是由点隔开的一系列的标识符组成。标识符可以是任何东西，但是一般都与消息的某些特性相关。一些合法的选择键的例子："stock.usd.nyse", "nyse.vmw","quick.orange.rabbit".你可以定义任何数量的标识符，上限为255个字节。

关于绑定键有两种特殊的情况。
*可以匹配一个标识符。
\#可以匹配0个或多个标识符。

## RabbitMQ + Spring

https://keyholesoftware.com/2013/04/01/rabbitmq-with-spring-tutorial/

direct
topic