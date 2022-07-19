FROM openjdk:8-jre-alpine
FROM maven:3.5-jdk-8-alpine AS maven
COPY . /app
RUN chmod 777 /app
WORKDIR /app
RUN mvn clean package
EXPOSE 8080
ENTRYPOINT ["java","-jar","target/SpringBootK8S.jar"]
