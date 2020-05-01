FROM openjdk:8-jdk-alpine

VOLUME /tmp

ARG JAR_FILE=/target/*.war

COPY ${JAR_FILE} app.jar

RUN echo "Creation of docker image is in progress..."

ENTRYPOINT ["java", "-jar", "app.jar"]

MAINTAINER "xxxxxxx@gmail.com"