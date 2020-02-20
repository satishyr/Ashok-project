FROM openjdk:8u151-jdk-slim-stretch
MAINTAINER SaiKrishna Hari <sainit08@gmail.com>
ADD target/eureka-server-0.0.1-SNAPSHOT.jar eurekaservice.jar
ENTRYPOINT ["java", "-Xmx144m","-jar", "/eurekaservice.jar"]