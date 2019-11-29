FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG TARGET=target
ARG JAR_FILE=employee-service-0.0.1-SNAPSHOT.jar
COPY ${TARGET}/${JAR_FILE} ${JAR_FILE}
ENTRYPOINT ["java","-jar","/${JAR_FILE}"]