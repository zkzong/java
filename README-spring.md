# spring-parent
[![Build Status](https://travis-ci.org/zkzong/spring-parent.svg?branch=master)](https://travis-ci.org/zkzong/spring-parent)
[![codecov](https://codecov.io/gh/zkzong/spring-parent/branch/master/graph/badge.svg)](https://codecov.io/gh/zkzong/spring-parent)

# 1. spring

Spring MVC

共5个例子：

1. 简单实例：HelloController
2. 表单提交实例：StudentController
3. 重定向实例：WebController
4. 静态页面实例：StaticWebController
5. 异常处理实例：ExceptionController

后面还添加了其他一些测试的例子
1. IterMap：遍历Map
2. ReForController：forward：地址栏不跳转；redirect：地址栏跳转
3. ValueController：使用@Value获取配置值时，声明的变量不能是static的
4. StudentController：@ModelAttribute注解的对象的值从url中获取，@RequestBody注解的对象的值从body中获取


## chapter1
### Servlet
访问方式：http://localhost:8080/servletLogin?submitFlag=toLogin
### JSP

## log4j

http://www.mkyong.com/spring-mvc/spring-mvc-log4j-integration-example/

web.xml
```xml
<web-app xmlns="http://java.sun.com/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://java.sun.com/xml/ns/javaee
	      http://java.sun.com/xml/ns/javaee/web-app_2_5.xsd"
         version="2.5">
```

mysql jar包用6.0版本数据库连接要加上时区

## Java Persistence with MyBatis 3

```xml
<insert id="insertStudent" parameterType="Student">
    INSERT INTO STUDENTS(STUD_ID,NAME,EMAIL,DOB) VALUES(#{studId},#{name},#{email},#{dob})
</insert>

<insert id="insertStudent" parameterType="Student">
    INSERT INTO STUDENTS(NAME,EMAIL,DOB) VALUES(#{name},#{email},#{dob})
</insert>

<insert id="insertStudent" parameterType="Student" useGeneratedKeys="true" keyProperty="studId">
	INSERT INTO STUDENTS(NAME,EMAIL,DOB) VALUES(#{name},#{email},#{dob})
</insert>
```
studId是自增主键，以上三种方式都可以插入成功。

### 使用XML配置MyBatis

+ environment
+ dataSource：UNPOOLED、POOLED、JNDI
+ TransactionManager：JDBC、MANAGED
+ properties：属性配置元素可以将配置值具体化到一个属性文件中，并且使用属性文件的key名作为占位符。可以在`<properties>`元素中配置默认参数的值。如果`<properties>`中定义的元素和属性文件定义元素的key值相同，它们会被属性文件中定义的值覆盖。
+ typeAliases
	- 在SQLMapper配置文件中，对于resultType和parameterType属性值，需要使用JavaBean的完全限定名。
    - 也可以为完全限定名去一个别名（alias），然后其需要使用完全限定名的地方使用别名，而不用到处使用完全限定名。
    ```xml
    <typeAliases>
        <typeAlias alias="Student" type="com.mybatis3.domain.Student" />
        <typeAlias alias="Tutor" type="com.mybatis3.domain.Tutor" />
        <package name="com.mybatis3.domain" />
    </typeAliases>
    ```
    - 也可以不用为每一个JavaBean单独定义别名，可以为提供需要取别名的JavaBean所在的包(package)，MyBatis会自动扫描包内定义的JavaBeans，然后分别为JavaBean注册一个小写字母开头的非完全限定的类名形式的别名。
    ```xml
    <typeAliases>
    	<package name="com.mybatis3.domain" />
    </typeAliases>
    ```
    - 使用注解@Alias。
    ```java
    @Alias("StudentAlias")
	public class Student{}
    ```
+ 类型处理器TypeHandler

### 使用XML配置SQL映射器

1. 通过字符串（字符串形式为：映射器配置文件所在的包名namespace + 在文件内定义的语句id，如 com.zkzong.mybatis.mapper.StudentMapper 和语句 id findStudentById 组成）调用映射的SQL语句。
2. MyBatis通过使用映射器Mapper接口提供了更好的调用映射语句。一旦通过映射器配置文件配置了映射语句，可以创建一个完全对应的一个映射器接口，接口名跟配置文件名相同，接口所在包名也跟配置文件所在包名完全一样。映射器接口中的方法签名也跟映射器配置文件中完全对应：方法名为配置文件中id值；方法参数类型为parameterType对应值；方法返回值类型为returnType对应值。

**自动生成主键**
可以使用useGeneratedKeys和keyProperty属性让数据库生成auto_increment列的值，并将生成的值设置到其中一个输入对象属性内。

+ 对于List、Collection、Iterable类型，MyBatis将返回java.util.ArrayList
+ 对于Map类型，MyBatis将返回java.util.HashMap
+ 对于Set类型，MyBatis将返回java.util.HashSet
+ 对于SortedSet类型，MyBatis将返回java.util.TreeSet

#### 结果集映射ResultMap
1. 简单ResultMap
2. 拓展ResultMap

#### 一对一映射
1. 使用嵌套结果ResultMap实现一对一关系映射：`<association>`
2. 使用嵌套查询实现一对一关系映射：

#### 一对多映射
1. 使用内嵌结果ResultMap实现一对多映射
2. 使用嵌套select语句实现一对多映射

#### 动态SQL
`<if>`
`<choose>`
`<where>`
`<foreach>`
`<trim>`
`<set>`

#### 传入多个输入参数
1. MyBatis中的映射语句有一个parameterType属性来指定输入参数的类型。如果想给映射语句传入多个参数的话，可以将所有的输入参数放到HashMap中，将HashMap传递给映射语句。
2. Mybatis还支持将多个输入参数传递给映射语句，并以#{param}的语法形式应用它们。

#### 使用RowBounds对结果集进行分页

#### 使用ResultSetHandler自定义结果集ResultSet处理

### 使用注解配置SQL映射器

@Insert
@Update
@Select

#### 动态SQL

@SelectProvider
@InsertProvider
@UpdateProvider
@DeleteProvider


**【注意mybatis和springmybatis版本】**

# 2. spring boot

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

# 3. spring-boot-2

## ratelimit

使用redis、AOP实现限流

## mq

### rabbitmq
+ [延迟队列](https://mp.weixin.qq.com/s?__biz=MzUzMTA2NTU2Ng==&mid=2247485829&idx=2&sn=59fd11d1b19d201fa958e8c9e11d1d2e&chksm=fa497634cd3eff22505453f31a210fd88dc11c3994e3582b955ca30e5059f3fda35f8ae0da65&mpshare=1&scene=1&srcid=1213KiT3TehNcUGcTFlgXwiB#rd)

# 4. spring-cloud

## spring-cloud-g

### ratelimit

zuul限流

http://localhost:5555/client/add?a=100&b=200

## spring-cloud-docker
Spring Cloud与Docker微服务架构实战

---

使用传统的Spring Boot构建项目
### spring-cloud-simple-provider-user
### spring-cloud-simple-consumer-movie

---

### spring-cloud-discovery-eureka
eureka注册中心

## spring-cloud-in-action
Spring Cloud微服务实战

## spring cloud alibaba