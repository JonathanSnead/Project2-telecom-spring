FROM openjdk:8-jre-alpine
EXPOSE 8080
RUN mkdir -p /app
COPY ./target/telecom-spring-0.0.1-SNAPSHOT.jar /app
WORKDIR /app
RUN sh -c 'touch telecom-spring-0.0.1-SNAPSHOT.jar'
ENTRYPOINT ["java", "-jar", "telecom-spring-0.0.1-SNAPSHOT.jar"]