FROM openjdk:17
FROM tomcat
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8090
#ADD target/site-0.0.1-SNAPSHOT.jar informa-br.jar
ENTRYPOINT ["java", "-jar", "app.jar"]