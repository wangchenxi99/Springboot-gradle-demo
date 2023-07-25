### JDK17环境
FROM openjdk:17

#应用构建成功后的jar文件被复制到镜像内，名字也改成了demo.jar
ADD build/libs/demo-0.0.1-SNAPSHOT.jar demo.jar

#启动容器最后执行命令
ENTRYPOINT ["java","-jar","/demo.jar"]

#暴露8888端口
EXPOSE 8088