# spring-security

## 登录

自定义登录页面是通过login-page属性来指定的。

不用登录访问：
```
<!-- 表示匿名用户可以访问 -->
<security:intercept-url pattern="/login.jsp" access="IS_AUTHENTICATED_ANONYMOUSLY"/>
```
通过指定“/login.jsp”的访问权限为“IS_AUTHENTICATED_ANONYMOUSLY”或“ROLE_ANONYMOUS”可以达到这一效果。
也可以通过指定一个http元素的安全性为none来达到相同的效果。
`<security:http security="none" pattern="/login.jsp" />`

指定登录后的页面：
+ 通过default-target-url指定
+ 通过authentication-success-handler-ref指定

指定登录失败后的页面：
+ 通过authentication-failure-url指定
+ 通过authentication-failure-handler-ref指定

http-basic：
弹窗认证
同时定义了http-basic和form-login元素时，form-login将具有更高的优先级。

获取当前用户的用户名：
```
public String getCurrentUsername() {
  Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
  if (principal instanceof UserDetails) {
     return ((UserDetails) principal).getUsername();
  }
  if (principal instanceof Principal) {
     return ((Principal) principal).getName();
  }
  return String.valueOf(principal);
}

// 最简单方式
public String getCurrentUsername() {
  return SecurityContextHolder.getContext().getAuthentication().getName();
}
```

## 认证

认证过程：
1. 用户使用用户名和密码进行登录。
2. Spring Security将获取到的用户名和密码封装成一个实现了Authentication接口的UsernamePasswordAuthenticationToken。
3. 将上述产生的token对象传递给AuthenticationManager进行登录认证。
4. AuthenticationManager认证成功后将会返回一个封装了用户权限等信息的Authentication对象。
5. 通过调用SecurityContextHolder.getContext().setAuthentication(...)将AuthenticationManager返回的Authentication对象赋予给当前的SecurityContext。

Web应用的认证过程：

如果用户直接访问登录页面，那么认证过程跟上节描述的基本一致，只是在认证完成后将跳转到指定的成功页面，默认是应用的根路径。如果用户直接访问一个受保护的资源，那么认证过程将如下：
1. 引导用户进行登录，通常是重定向到一个基于form表单进行登录的页面，具体视配置而定。
2. 用户输入用户名和密码后请求认证，后台还是会像上节描述的那样获取用户名和密码封装成一个UsernamePasswordAuthenticationToken对象，然后把它传递给AuthenticationManager进行认证。
3. 如果认证失败将继续执行步骤1，如果认证成功则会保存返回的Authentication到SecurityContext，然后默认会将用户重定向到之前访问的页面。
4. 用户登录认证成功后再次访问之前受保护的资源时就会对用户进行权限鉴定，如不存在对应的访问权限，则会返回403错误码。

用户信息从数据库获取：
+ 使用jdbc-user-service获取
+ 直接使用JdbcDaoImpl

需要注意的是使用jdbc-user-service定义的UserDetailsService是不支持用户组权限的，如果需要支持用户组权限的话需要我们使用JdbcDaoImpl。

## intercept-url配置

### 指定拦截的url
通过pattern指定当前intercept-url定义应当作用于哪些url。
`<security:intercept-url pattern="/**" access="ROLE_USER"/>`

### 指定访问权限
可以通过access属性来指定intercept-url对应URL访问所应当具有的权限。access的值是一个字符串，其可以直接是一个权限的定义，也可以是一个表达式。常用的类型有简单的角色名称定义，多个名称之间用逗号分隔，如：
`<security:intercept-url pattern="/secure/**" access="ROLE_USER,ROLE_ADMIN"/>`
在上述配置中就表示secure路径下的所有URL请求都应当具有ROLE_USER或ROLE_ADMIN权限。当access的值是以“ROLE_”开头的则将会交由RoleVoter进行处理。
 
此外，其还可以是一个表达式，上述配置如果使用表达式来表示的话则应该是如下这个样子。
```
<security:http use-expressions="true">
  <security:form-login />
  <security:logout />
  <security:intercept-url pattern="/secure/**" access="hasAnyRole('ROLE_USER','ROLE_ADMIN')"/>
</security:http>
```
或者是使用hasRole()表达式，然后中间以or连接，如：
`<security:intercept-url pattern="/secure/**" access="hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')"/>`
需要注意的是使用表达式时需要指定http元素的use-expressions=”true”。当intercept-url的access属性使用表达式时默认将使用WebExpressionVoter进行处理。
此外，还可以指定三个比较特殊的属性值，默认情况下将使用AuthenticatedVoter来处理它们。
IS_AUTHENTICATED_ANONYMOUSLY表示用户不需要登录就可以访问；
IS_AUTHENTICATED_REMEMBERED表示用户需要是通过Remember-Me功能进行自动登录的才能访问；
IS_AUTHENTICATED_FULLY表示用户的认证类型应该是除前两者以外的，也就是用户需要是通过登录入口进行登录认证的才能访问。
如我们通常会将登录地址设置为IS_AUTHENTICATED_ANONYMOUSLY。
```
<security:http>
  <security:form-login login-page="/login.jsp"/>
  <!-- 登录页面可以匿名访问 -->
  <security:intercept-url pattern="/login.jsp*" access="IS_AUTHENTICATED_ANONYMOUSLY"/>
  <security:intercept-url pattern="/**" access="ROLE_USER"/>
</security:http>
```

### 指定访问协议
如果你的应用同时支持Http和Https访问，且要求某些URL只能通过Https访问，这个需求可以通过指定intercept-url的requires-channel属性来指定。
requires-channel支持三个值：http、https和any。any表示http和https都可以访问。
```
<security:http auto-config="true">
  <security:form-login/>
  <!-- 只能通过https访问 -->
  <security:intercept-url pattern="/admin/**" access="ROLE_ADMIN" requires-channel="https"/>
  <!-- 只能通过http访问 -->
  <security:intercept-url pattern="/**" access="ROLE_USER" requires-channel="http"/>
  <security:port-mappings>
     <security:port-mapping http="8899" https="9988"/>
  </security:port-mappings>
</security:http>
```

### 指定请求方法
通常我们都会要求某些URL只能通过POST请求，某些URL只能通过GET请求。这些限制Spring Security也已经为我们实现了，通过指定intercept-url的method属性可以限制当前intercept-url适用的请求方式，默认为所有的方式都可以。
```xml
<security:http auto-config="true">
  <security:form-login/>
  <!-- 只能通过POST访问 -->
  <security:intercept-url pattern="/post/**" method="POST"/>
  <!-- 只能通过GET访问 -->
  <security:intercept-url pattern="/**" access="ROLE_USER" method="GET"/>
</security:http>
```
method的可选值有GET、POST、DELETE、PUT、HEAD、OPTIONS和TRACE。

## 退出登录
要实现退出登录的功能我们需要在http元素下定义logout元素，这样Spring Security将自动为我们添加用于处理退出登录的过滤器LogoutFilter到FilterChain。
当我们指定了http元素的auto-config属性为true时logout定义是会自动配置的，此时我们默认退出登录的URL为“/j_spring_security_logout”，可以通过logout元素的logout-url属性来改变退出登录的默认地址。
`<security:logout logout-url="/logout.do"/>`

此外，我们还可以给logout指定如下属性：

|属性名|作用|
|--|--|
|invalidate-session|表示是否要在退出登录后让当前session失效，默认为true。|
|delete-cookies|指定退出登录后需要删除的cookie名称，多个cookie之间以逗号分隔。|
|logout-success-url|指定成功退出登录后要重定向的URL。需要注意的是对应的URL应当是不需要登录就可以访问的。|
|success-handler-ref|指定用来处理成功退出登录的LogoutSuccessHandler的引用。|