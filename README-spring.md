# spring

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

1. 通过字符串（字符串形式为：映射器配置文件所在的包名namespace + 在文件内定义的语句id，如 com.example.mybatis.mapper.StudentMapper 和语句 id findStudentById 组成）调用映射的SQL语句。
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
