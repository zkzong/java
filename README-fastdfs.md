# fastdfs

## fastdfs-spring-csource
```xml
<dependency>
	<groupId>org.csource</groupId>
	<artifactId>fastdfs-client-java</artifactId>
	<version>1.27-RELEASE</version>
</dependency>
```
使用`csource`时配置：
```xml
tracker_server=10.152.36.46:22122
```
`tracker_server`这个key不能修改，`10.152.36.46:22122`这个value不能是多个，如`10.152.36.46:22122,10.152.36.58:22122`会报错

## fastdfs-spring-oschina
```xml
<dependency>
	<groupId>net.oschina.zcx7878</groupId>
	<artifactId>fastdfs-client-java</artifactId>
	<version>1.27.0.0</version>
</dependency>
```