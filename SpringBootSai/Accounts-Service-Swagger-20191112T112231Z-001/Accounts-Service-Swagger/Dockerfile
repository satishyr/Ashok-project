FROM maven:3.5-jdk-8-alpine

VOLUME /tmp

MAINTAINER sainit08@gmail.com

WORKDIR /app

ADD . /app

RUN mvn package -DskipTests=true -Ddir=app

ADD target/Accounts-Service-0.0.1-SNAPSHOT.jar accounts-microservice.jar

EXPOSE 9192

ENV JAVA_OPTS=""

ENTRYPOINT ["sh","-c","java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar accounts-microservice.jar"]