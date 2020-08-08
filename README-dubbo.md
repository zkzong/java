# dubbo

## dubbo-sb

使用xml方式实现，但是没有提取api层，服务提供者和消费者都需要定义接口，不建议使用：
dubbo-consumer
dubbo-service

使用xml方式实现：
dubbo-api-consumer
dubbo-api-service

使用注解方式实现:
dubbo-spring-boot-api
dubbo-spring-boot-consumer
dubbo-spring-boot-provider

## dubbo-sb2

使用注解方式实现，添加配置项

## dubbo-sca

使用nacos作为注册中心

## dubbo-spring

### dubbo-simple-demo

### 作为web项目启动并注册

dubbo-spring-web-facade
提供的接口

dubbo-spring-web-provider
生产者

dubbo-spring-web-consumer
消费者


### 使用com.alibaba.dubbo.container.Main注册
dubbo-web-main （web工程）

dubbo-main （非web工程）
