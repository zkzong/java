# spring-boot-2

## ratelimit

使用redis、AOP实现限流

## executor
spring boot异步
优势？？？

## map
将实现同一接口的Service注入到Map当中

## actuator
```properties
# 开放所有端口
management.endpoints.web.exposure.include=*
# 打印health详细信息
management.endpoint.health.show-details=always
```

### 扩展health、info信息
CustomerServiceHealthIndicator
CustomBuildInfoContributor

### 自定义 Actuator 端点
MySystemEndpoint
http://localhost:8080/actuator/mysystem

## listener
事件监听4种方式：
1、context.addApplicationListener(new MyListener1());
2、Listener类上添加注解@Component
3、配置文件中添加context.listener.classes=listener.org.example.MyListener3
4、不实现ApplicationListener，但是在方法上添加注解@EventListener；如果要指定监听类型，可以`@EventListener(String.class)`，即只监听String

https://mp.weixin.qq.com/s/_y6PC4VFa1wlGlprtuRs1A

## log-aspect

使用注解+切面方式打印日志


