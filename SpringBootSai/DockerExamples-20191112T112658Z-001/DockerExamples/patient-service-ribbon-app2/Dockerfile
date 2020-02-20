FROM openjdk:8u151-jdk-slim-stretch
MAINTAINER SaiKrishna Hari <sainit08@gmail.com>
ADD target/patient-service-ribbon-app2-0.0.1-SNAPSHOT.jar patientservice.jar
ENTRYPOINT ["java", "-Xmx144m","-jar", "/patientservice.jar"]