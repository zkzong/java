# spring boot

Spring Boot设计目的是用来简化新Spring应用的初始搭建以及开发过程该框架使用了特定的方式来进行配置，从而使开发人员不再需要定义样板化的配置。

## deploy-war

不使用Spring Boot内置的tomcat启动服务

启动类继承SpringBootServletInitializer

打包成**war**包:
```
<packaging>war</packaging>
```

## didispace

### aop
在切入点前的操作，按order的值由小到大执行

在切入点后的操作，按order的值由大到小执行

### actuator
指定端口：
```properties
management.port=8080
```

关闭端口
```properties
# 1. 关闭全部端口，只打开某个端口
endpoints.enabled=false
endpoints.info.enabled=true
endpoints.health..enabled=true

# 2. 只关闭某个端口
endpoints.actuator.enabled=false
```

添加依赖：
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>
```
management.security.enabled需要设置为true，security才起作用，默认即为true。
默认用户名：user
密码：打印在控制台，比如：
`Using default security password: 71f1bd96-f332-48aa-be74-e3022c6248bb`

### async
@Async所修饰的函数不要定义为static类型，这样异步调用不会生效

### banner
+ ${AnsiColor.BRIGHT_RED}：设置控制台中输出内容的颜色
+ ${application.version}：用来获取MANIFEST.MF文件中的版本号
+ ${application.formatted-version}：格式化后的${application.version}版本信息
+ ${spring-boot.version}：Spring Boot的版本号
+ ${spring-boot.formatted-version}：格式化后的${spring-boot.version}版本信息

### scheduled
+ @Scheduled(fixedRate = 5000) ：上一次开始执行时间点之后5秒再执行
+ @Scheduled(fixedDelay = 5000) ：上一次执行完毕时间点之后5秒再执行
+ @Scheduled(initialDelay=1000, fixedRate=5000) ：第一次延迟1秒后执行，之后按fixedRate的规则每5秒执行一次
+ @Scheduled(cron="*/5 * * * * *") ：通过cron表达式定义规则

## DeepintoSpringBoot
深入实践Spring Boot

### spring-boot-db
在Spring Boot中使用数据库

#### MySQL


### spring-boot-db
### 开启监控功能

DruidConfiguration

通过网址[http://localhost/druid/index.html](http://localhost/druid/index.html)打开控制台

### 使用Spring Cache注解

要使用注解的方式调用缓存，必须在配置类中启用Spring Cache。

## properties

配置属性转换成实体类

### @ConfigurationProperties
@ConfigurationProperties(prefix = "prefix")

### @PropertySource
@PropertySource(value = {"classpath:common.properties"})

## roncoo
[http://www.roncoo.com/course/view/e4189c9db6474745b5e578983cddd112](http://www.roncoo.com/course/view/e4189c9db6474745b5e578983cddd112)

spring-boot-devtools 开发工具包

直接运行main方法或者使用maven命令: `mvn spring-boot:run`

测试： http://localhost:8080/index

带参数：http://localhost:8080/index/get?name=wujing

带参数有中文：http://localhost:8080/index/get?name=无境

url测试：http://localhost:8080/index/get/1/wujing

url测试：http://localhost:8080/index/get/1/无境

## runner

应用启动时运行。

实现CommandLineRunner或ApplicationRunner接口。

## startup

启动服务的方式：
1. 启动类加上注解`@EnableAutoConfiguration`，即使加入web模块，web功能仍然报错
2. `@SpringBootApplication`

## shutdown

优雅停机
