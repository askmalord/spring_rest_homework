FROM openjdk:8-jdk-alpine
EXPOSE 8080
ADD target/spring_REST_homework-0.0.1-SNAPSHOT.jar appRest.jar
ENTRYPOINT ["java", "-jar", "appRest.jar"]