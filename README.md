# java

# javabasics

Java基础知识

## algorithm 算法

## collection 集合

## designpattern 设计模式

com.zkzong.designpattern.zen.DynamicProxy 动态代理：
要实现动态代理的首要条件是：被代理类必须实现一个接口

工厂方法模式
com.zkzong.designpattern.zen.factory.simplefactory.section1

通用工厂方法模式
com.zkzong.designpattern.zen.factory.simplefactory.section2

简单工厂模式
com.zkzong.designpattern.zen.factory.simplefactory.section3

工厂方法模式--多个工厂类
com.zkzong.designpattern.zen.factory.simplefactory.section4

工厂方法模式实现单例模式
com.zkzong.designpattern.zen.factory.simplefactory.section5

延迟初始化
com.zkzong.designpattern.zen.factory.simplefactory.section6

## ehcache

## interview 面试

## jvm

## reflect

### Class类提供了四个public方法，用于获取某个类的构造方法
+ Constructor getConstructor(Class[] params) 根据构造函数的参数，返回一个具体的具有public属性的构造函数
+ Constructor getConstructors() 返回所有具有public属性的构造函数数组
+ Constructor getDeclaredConstructor(Class[] params) 根据构造函数的参数，返回一个具体的构造函数（不分public和非public属性）
+ Constructor getDeclaredConstructors() 返回该类中所有的构造函数数组（不分public和非public属性）

### 四种获取成员方法的方法
+ Method getMethod(String name, Class[] params) 根据方法名和参数，返回一个具体的具有public属性的方法
+ Method[] getMethods() 返回所有具有public属性的方法数组
+ Method getDeclaredMethod(String name, Class[] params) 根据方法名和参数，返回一个具体的方法（不分public和非public属性）
+ Method[] getDeclaredMethods() 根据方法名和参数，返回一个具体的方法（不分public和非public属性）

### 四种获取成员属性的方法
+ Field getField(String name) 根据变量名，返回一个具体的具有public属性的成员变量
+ Field[] getFields() 返回具有public属性的成员变量的数组
+ Field getDeclaredField(String name) 根据变量名，返回一个成员变量（不分public和非public属性）
+ Field[] getDeclaredFields() 返回所有成员变量组成的数组（不分public和非public属性）

## test

## thinkinginjava Java编程思想

## thread 多线程

synchronized是Java中的关键字，是一种同步锁。它修饰的对象有以下几种：
1. 修饰一个代码块，被修饰的代码块称为同步语句块，其作用的范围是大括号{}括起来的代码，作用的对象是调用这个代码块的对象；
2. 修饰一个方法，被修饰的方法称为同步方法，其作用的范围是整个方法，作用的对象是调用这个方法的对象；
3. 修改一个静态的方法，其作用的范围是整个静态方法，作用的对象是这个类的所有对象；
4. 修改一个类，其作用的范围是synchronized后面括号括起来的部分，作用主的对象是这个类的所有对象。

在用synchronized修饰方法时要注意以下几点：
1. synchronized关键字不能继承。
2. 在定义接口方法时不能使用synchronized关键字。
3. 构造方法不能使用synchronized关键字，但可以使用synchronized代码块来进行同步。

A. 无论synchronized关键字加在方法上还是对象上，如果它作用的对象是非静态的，则它取得的锁是对象；如果synchronized作用的对象是一个静态方法或一个类，则它取得的锁是对类，该类所有的对象同一把锁。
B. 每个对象只有一个锁（lock）与之相关联，谁拿到这个锁谁就可以运行它所控制的那段代码。
C. 实现同步是要很大的系统开销作为代价的，甚至可能造成死锁，所以尽量避免无谓的同步控制。



Runnable 的 run 方法是不带返回值的，那如果我们需要一个耗时任务在执行完之后给予返回值，应该怎么做呢？

第一种方法：在 Runnable 的实现类中设置一个变量 V，在 run 方法中将其改变为我们期待的结果，然后通过一个 getV() 方法将这个变量返回。
RunnableTest 

第二种方法：使用 Callable<V> 和 FutureTask<V>。 
Callable<V> 是 JDK1.5 时添加的类，为的就是解决 Runnable 的痛点（没有返回值和不能抛出异常）。
CallableTest


# thirdparty

## apache commons

## common

公共

## elastic-job
分布式定时任务

## guava

## json

### fastjson
### gson
### jackson
### sfjson

## lombok
IDE需要安装lombok插件，否则编译报错

## mockito

## okhttp

## orika
根据字段名称赋值，类型不一样也可以赋值。

## pdf

### itext

### pdf2image
使用pdfbox，把pdf转换成图片

可以把整个pdf转成一张图片，也可以每页pdf转成一张图片

## pinyin4j

## poi

## snowflake
雪花算法
+ struqt-unique-id

## spring
spring工具类
+ BeanUtils

## trove

使用lombok


# library

常用代码

## file-type
校验文件类型

## image
- 图片和字符串相互转换

## pdf
- pdf和字符串相互转换
- pdf转成图片

## properties
读取配置文件

### Properties
### ResourceBundle