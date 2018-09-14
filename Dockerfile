FROM java:8
MAINTAINER huxin <491037720@qq.com>

#update system timezone
RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime
#update application timezone
RUN echo "Asia/Shanghai" >> /etc/timezone

#ADD pom.xml /tmp/build/
#ADD src /tmp/build/src
#RUN cd /tmp/build && mvn clean package && mkdir -p /jar && mv target/*.jar /jar/microservice-simple-provider-user.jar \
    # && cd / && rm -rf /tmp/build
     
VOLUME ["/data/logs"]

ARG JAR_FILE
ADD ${JAR_FILE} /app/mavendockerplugindemo.jar
WORKDIR /app/
EXPOSE 8889

ENV JAVA_OPTS -Dspring.profiles.active=test
ENTRYPOINT ["java","-jar","./mavendockerplugindemo.jar"]
