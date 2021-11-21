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


