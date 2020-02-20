FROM openjdk:8u151-jdk-slim-stretch
MAINTAINER SaiKrishna Hari <sainit08@gmail.com>
ADD target/doctor-service-0.0.1-SNAPSHOT.jar doctorservice.jar
ENTRYPOINT ["java", "-Xmx144m","-jar", "/doctorservice.jar"]