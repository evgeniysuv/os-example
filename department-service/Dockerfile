FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
COPY target/department-service-0.0.1-SNAPSHOT.jar department-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/department-service-0.0.1-SNAPSHOT.jar"]