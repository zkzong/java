# 指定基础镜像，本地没有会从dockerHub pull下来
FROM java:8
# 可执行jar何复制到基础镜像的根目录下
ADD target/spring-boot-log4j2-1.0-SNAPSHOT.jar /spring-boot-log4j2.jar
# 镜像要暴露旳端口，如要使用端口，在执行docker run命令时使用-p生效
EXPOSE 8080
# 在镜像运行为容器后执行旳命令
ENTRYPOINT ["java", "-jar", "/spring-boot-log4j2.jar"]
